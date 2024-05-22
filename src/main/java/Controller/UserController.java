package Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
//    get: username+password->登录token(uid)----------登录（加密处理）
    @CrossOrigin
    @RequestMapping("/login")
    public String login(){
        return "getLoginToken";
    }

//    post: username+password->登录token(uid)---------注册（加密处理）
    @CrossOrigin
    @RequestMapping("/register")
    public String register(){
        return "postRegistrationInfo";
    }
}
