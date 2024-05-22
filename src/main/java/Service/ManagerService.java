package Service;

import Entity.Travelogue;
import Entity.User;

import java.util.List;

public interface ManagerService {
    public List<User> getAllUsers(long managerId);
    public List<Travelogue> getAllLogsByManager(long managerId);
    public List<Travelogue> getNotExaminedLogs(long managerId);
    public boolean putUserLockState(long managerId, long userId, int isLock);
    public boolean putLogExamState(long managerId, long travelogueId, String status, String comment);
}
