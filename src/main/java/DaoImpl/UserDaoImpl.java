package DaoImpl;

import Dao.UserDao;
import Entity.User;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    public String getPasswordById(long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders getUserHeaders = new HttpHeaders();
        getUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        getUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> getUserResponse = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user?user.user_id="+userId, String.class);

        ObjectMapper getUserObjectMapper = new ObjectMapper();
        try {
            JsonNode root = getUserObjectMapper.readTree(getUserResponse.getBody());
            JsonNode dataNode = root.get("data");
            CollectionType listType = getUserObjectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            List<User> userList = getUserObjectMapper.readValue(dataNode.asText(), listType);
            if(userList.size() != 1){
                return null;
            } else {
                return userList.get(0).getPassword();
            }

        } catch (Exception e){
            return null;
        }
    }

    public String postUser(String userInfo){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders PostUserHeaders = new HttpHeaders();
        PostUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        PostUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> PostUserRequestEntity = new HttpEntity<>(userInfo, PostUserHeaders);
        ResponseEntity<String> PostUserResponse = restTemplate.postForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user", PostUserRequestEntity, String.class);

        return PostUserResponse.getBody();
    }

    public List<User> getUsersByUsername(String username){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders GetUserHeaders = new HttpHeaders();
        GetUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        GetUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> GetUserResponse = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user?user.username="+username,String.class);

        ObjectMapper GetUserObjectMapper = new ObjectMapper();
        try {
            JsonNode root = GetUserObjectMapper.readTree(GetUserResponse.getBody());
            JsonNode dataNode = root.get("data");
            CollectionType listType = GetUserObjectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            List<User> userList = GetUserObjectMapper.readValue(dataNode.asText(), listType);
            return userList;
        } catch (Exception e){
            return null;
        }
    }

    public List<User> getAllUsers(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders GetUserHeaders = new HttpHeaders();
        GetUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        GetUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> GetUserResponse = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user", String.class);

        ObjectMapper GetUserObjectMapper = new ObjectMapper();
        try {
            JsonNode root = GetUserObjectMapper.readTree(GetUserResponse.getBody());
            JsonNode dataNode = root.get("data");
            CollectionType listType = GetUserObjectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            List<User> userList = GetUserObjectMapper.readValue(dataNode.asText(), listType);
            return userList;
        } catch (Exception e){
            return null;
        }
    }
    public boolean putIsLock(long userId, int isLock){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders GetUserHeaders = new HttpHeaders();
        GetUserHeaders.setContentType(MediaType.APPLICATION_JSON);
        GetUserHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> GetUserResponse = restTemplate.getForEntity("http://202.120.40.86:14642/rmp-resource-service/project/663f50f98562cc0015aaf2cf/resource/user?user.user_id="+userId, String.class);

        ObjectMapper GetUserObjectMapper = new ObjectMapper();
        try {
            JsonNode root = GetUserObjectMapper.readTree(GetUserResponse.getBody());
            JsonNode dataNode = root.get("data");
            CollectionType listType = GetUserObjectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            List<User> userList = GetUserObjectMapper.readValue(dataNode.asText(), listType);
            if(userList.size() != 1){
                return false;
            } else {
                User user = userList.get(0);
                user.setIsBan(isLock);
                String userPutInfo = GetUserObjectMapper.writeValueAsString(user);
                postUser(userPutInfo);
                return true;
            }

        } catch (Exception e){
            return false;
        }
    }
}
