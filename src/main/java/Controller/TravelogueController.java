package Controller;

import ServiceImpl.TravelogueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class TravelogueController {

//    无登录
//    get: 默认推荐游记（热度排序）
    @CrossOrigin
    @RequestMapping("/getAllLogs")
    public String getAllLogs(){
        return "getAllLogs";
    }

//    get: uid->推荐游记------------------------------推荐算法
    @CrossOrigin
    @RequestMapping("/getRecommendedLogs")
    public String getRecommendedLogs(@RequestParam("uid") String uid){
        return "getRecommendedLogs";
    }

//    post: uid+游记+其他信息----------------------------------补全游记信息，建立反向索引
    @CrossOrigin
    @RequestMapping("/postLog")
    public String postLog(@RequestParam("uid") String uid){
        return "postLog";
    }

//    post: uid+评论+游记id
    @CrossOrigin
    @RequestMapping("/postComment")
    public String postComment(@RequestParam("uid") String uid){
        return "postComment";
    }

//    get: uid->自己的所有游记（包含状态）
    @CrossOrigin
    @RequestMapping("/getAllMyLogs")
    public String getAllMyLogs(@RequestParam("uid") String uid){
        return "getAllMyLogs";
    }

//    get: 搜索词->搜索的游记----------------------反向索引+推荐排序
    @CrossOrigin
    @RequestMapping("/getSearchedLogs")
    public String getSearchedLogs(@RequestParam("uid") String uid){
        return "getSearchedLogs";
    }

//    get: 游记id->游记
    @CrossOrigin
    @RequestMapping("/getOneLog")
    public String getOneLog(@RequestParam("uid") String uid){
        return "getOneLog";
    }
}
