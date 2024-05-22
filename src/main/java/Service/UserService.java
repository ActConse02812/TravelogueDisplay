package Service;

import Entity.Msg;
import com.alibaba.fastjson.JSONObject;

public interface UserService {
    public String getLoginToken(String username, String password);
    public Msg postRegistrationInfo(JSONObject jsonObject);
}
