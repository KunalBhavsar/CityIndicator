package co.cityindicator.core;

/**
 * Contain information related to the entity to entity rating.
 * Created by Kunal Bhavsar on 28/1/16.
 */
public class Rating extends Base {
    /**
     * Rating in the range of 0 - 5
     */
    private int rating;
    /**
     * Comments for the rating given, not mandatory.
     */
    private String comment;
    /**
     * Rating given by.
     */
    private Entity fromEntity;
    /**
     * Rating given to.
     */
    private Entity toEntity;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Entity getFromEntity() {
        return fromEntity;
    }

    public void setFromEntity(Entity fromEntity) {
        this.fromEntity = fromEntity;
    }

    public Entity getToEntity() {
        return toEntity;
    }

    public void setToEntity(Entity toEntity) {
        this.toEntity = toEntity;
    }
}
