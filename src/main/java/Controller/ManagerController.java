package Controller;

import Entity.Msg;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class ManagerController {
//    管理员
//    get: uid->全部用户
    @CrossOrigin
    @RequestMapping("/getAllUsers")
    public String getAllUsers(@RequestParam("uid") String uid){
        return "getAllUsers";
    }

//    get: uid->全部游记
    @CrossOrigin
    @RequestMapping("/getAllLogsByManager")
    public String getAllLogsByManager(@RequestParam("uid") String uid){
        return "getAllLogsByManager";
    }

//    get: uid->待审核游记
    @CrossOrigin
    @RequestMapping("/getNotExaminedLogs")
    public String getNotExaminedLogs(@RequestParam("uid") String uid){
        return "getNotExaminedLogs";
    }

//    put: uid+禁用/解禁
    @CrossOrigin
    @RequestMapping("/putUserLockState")
    public String putUserLockState(@RequestParam("uid") String uid){
        return "putUserLockState";
    }

//    put: 游记id+审核状态
    @CrossOrigin
    @RequestMapping("/putLogExamState")
    public String putLogExamState(@RequestParam("uid") String uid){
        return "putLogExamState";
    }

    @CrossOrigin
    @RequestMapping("/Ban")
    public Msg banUser(@RequestBody JSONObject jsonObject){
        Integer id = (Integer) jsonObject.get("id");
        Long userId = (Long) jsonObject.get("user_id");
        jsonObject.put("user_id", userId);
        jsonObject.put("isBan",1);
        String username = jsonObject.getString("username");
        String url = "http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user/"+id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders PutUserHeaders = new HttpHeaders();
        PutUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        PutUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> PutUserRequestEntity = new HttpEntity<>(jsonObject.toString(), PutUserHeaders);
        ResponseEntity<String> PutUserResponse = restTemplate.exchange(url, HttpMethod.PUT, PutUserRequestEntity, String.class);
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMessage("禁用用户"+username);
        msg.setData(PutUserResponse.getBody());
        return msg;
    }
}
