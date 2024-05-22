package Entity;

import java.util.List;

public class Travelogue {
    private long id;
    private String preface;
    private String mainBody;
    private String photoDescription;
    private String address;
    private String members;
    private String title;
    private String departureTime;
    private int duration;
    private int cost;
    private long likes;
    private long views;
    private long shares;
    private String createTime;
    private User author;
    private Status status;
    private List<Image> images;
    private List<Comment> comments;

    public Travelogue(long id, String preface, String mainBody, String photoDescription, String address, String members, String title, String departureTime, int duration, int cost, long likes, long views, long shares, String createTime, User author, Status status, List<Image> images, List<Comment> comments) {
        this.id = id;
        this.preface = preface;
        this.mainBody = mainBody;
        this.photoDescription = photoDescription;
        this.address = address;
        this.members = members;
        this.title = title;
        this.departureTime = departureTime;
        this.duration = duration;
        this.cost = cost;
        this.likes = likes;
        this.views = views;
        this.shares = shares;
        this.createTime = createTime;
        this.author = author;
        this.status = status;
        this.images = images;
        this.comments = comments;
    }

    public Travelogue() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getShares() {
        return shares;
    }

    public void setShares(long shares) {
        this.shares = shares;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
