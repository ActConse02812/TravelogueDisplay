package Service;

import Entity.Travelogue;

import java.util.List;

public interface TravelogueService {
    public List<Travelogue> getAllExaminedLogs();
    public List<Travelogue> getRecommendedLogs(long userId);
    public boolean postLog(long userId);
    public boolean postComment(long userId);
    public boolean getAllMyLogs(long userId);
    public List<Travelogue> getSearchedLogs(String searchWords);
    public Travelogue getLogById(long travelogueId);
}
