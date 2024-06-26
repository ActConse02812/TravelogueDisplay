package Dao;

import Entity.User;

import java.util.List;

public interface UserDao {
    public String getPasswordById(long userId);
    public String postUser(String userInfo);
    public List<User> getUsersByUsername(String username);
    public List<User> getAllUsers();
    public boolean putIsLock(long userId, int isLock);
}
