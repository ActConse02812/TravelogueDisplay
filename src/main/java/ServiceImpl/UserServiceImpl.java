package ServiceImpl;

import Dao.UserDao;
import Entity.Msg;
import Entity.User;
import Service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public String getLoginToken(String username, String password){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> response = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user",String.class);

        String responseBody = response.getBody();

        return responseBody;
    }

    public Msg postRegistrationInfo(JSONObject jsonObject){
        String username = jsonObject.getString("username");
        List<User> userList = userDao.getUsersByUsername(username);
        if(userList == null){
            Msg msg = new Msg();
            msg.setCode(404);
            msg.setMessage("连接错误");
            msg.setData("");
            return msg;
        } else if(!userList.isEmpty()){
                Msg msg = new Msg();
                msg.setCode(500);
                msg.setMessage("用户已存在");
                msg.setData("");
                return msg;
        } else {
            String response = userDao.postUser(jsonObject.toString());
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMessage(username+"成功注册！");
            msg.setData(response);
            return msg;
        }
    }
}
