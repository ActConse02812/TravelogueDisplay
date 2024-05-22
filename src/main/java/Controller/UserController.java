package Controller;

import Service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserService userService;

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
        return userService.postRegistrationInfo(jsonObject);
    }
}
