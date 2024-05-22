package Controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import Entity.Msg;

import java.util.Collections;

@RestController
public class UserController {
//    get: username+password->登录token(uid)----------登录（加密处理）
    @CrossOrigin
    @RequestMapping("/login")
    public String login(){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> response = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user",String.class);

        String responseBody = response.getBody();

        return responseBody;
    }

//    post: username+password->登录token(uid)---------注册（加密处理）
    @CrossOrigin
    @RequestMapping ("/register")
    public Msg register(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders GetUserHeaders = new HttpHeaders();
        GetUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        GetUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> GetUserResponse = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user?user.username="+username,String.class);

        ObjectMapper GetUserObjectMapper = new ObjectMapper();
        try {
            JsonNode root = GetUserObjectMapper.readTree(GetUserResponse.getBody());
            JsonNode dataNode = root.get("data");
            if (dataNode.isArray() && dataNode.size()!=0){
                Msg msg = new Msg();
                msg.setCode(500);
                msg.setMessage("用户已存在");
                msg.setData("");
                return msg;
            }else {
                HttpHeaders PostUserHeaders = new HttpHeaders();
                PostUserHeaders.setContentType(MediaType.APPLICATION_JSON);
                PostUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                HttpEntity<String> PostUserRequestEntity = new HttpEntity<>(jsonObject.toString(), PostUserHeaders);
                ResponseEntity<String> PostUserResponse  = restTemplate.postForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user",PostUserRequestEntity,String.class);
                Msg msg = new Msg();
                msg.setCode(200);
                msg.setMessage(username+"成功注册！");
                msg.setData(PostUserResponse.getBody());
                return msg;
            }


        } catch (Exception e){
            Msg msg = new Msg();
            msg.setCode(404);
            msg.setMessage("连接错误");
            msg.setData("");
            return msg;
        }
    }
}
