package Entity;

public class Status {
    private long statusId;
    private String comment;

    public Status(long statusId, String comment, String status) {
        this.statusId = statusId;
        this.comment = comment;
        this.status = status;
    }

    public Status() {
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
}
