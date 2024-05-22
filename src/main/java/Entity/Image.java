package Entity;

public class Image {
    private long imageId;
    private String image;

    public Image() {
    }

    public Image(long imageId, String image) {
        this.imageId = imageId;
        this.image = image;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
