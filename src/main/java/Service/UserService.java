package Service;

public interface UserService {
    public String getLoginToken(String username, String password);
    public String postRegistrationInfo(String username, String password);
}
