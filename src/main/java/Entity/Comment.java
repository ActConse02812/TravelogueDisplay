package Entity;

public class Comment {
    private long commentId;
    private String content;
    private long likes;
    private User author;

    public Comment(long commentId, String content, long likes, User author) {
        this.commentId = commentId;
        this.content = content;
        this.likes = likes;
        this.author = author;
    }

    public Comment() {
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
