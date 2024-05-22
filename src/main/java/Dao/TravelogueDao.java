package Dao;

import Entity.Status;
import Entity.Travelogue;

import java.util.List;

public interface TravelogueDao {
    public Travelogue getTravelogueById(long id);
    public List<Travelogue> getAllTravelogues();
    public List<Travelogue> getAllExaminedLogs();
    public List<Travelogue> getTraveloguesByUserId(long uid);
    public boolean postTravelogue(Travelogue travelogue);
    public List<Travelogue> getAllNotExaminedLogs();
    public boolean putExamineState(long TravelogueId, Status status);
}
