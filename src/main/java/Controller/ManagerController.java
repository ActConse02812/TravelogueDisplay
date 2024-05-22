package Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
