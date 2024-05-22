package Entity;

public class User {
    private long userId;
    private String password;
    private String authorization;
    private String username;
    private int isLogin;
    private int isBan;

    public User(long userId, String password, String authorization, String username, int isLogin, int isBan) {
        this.userId = userId;
        this.password = password;
        this.authorization = authorization;
        this.username = username;
        this.isLogin = isLogin;
        this.isBan = isBan;
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public int getIsBan() {
        return isBan;
    }

    public void setIsBan(int isBan) {
        this.isBan = isBan;
    }
}
