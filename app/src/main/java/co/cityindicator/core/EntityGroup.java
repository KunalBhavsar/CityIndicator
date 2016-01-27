package co.cityindicator.core;

import java.util.ArrayList;

/**
 * Contain information related to group of entities.
 * Created by Kunal Bhavsar on 27/1/16.
 */
public class EntityGroup extends Base {

    /**
     * Common group name constants
     */
    public static final String DOCTOR = "Doctors";
    public static final String ENGINEER = "Engineers";

    /**
     * Name of the group (Doctor, Engineer etc).
     */
    private String groupName;
    /**
     * Set of entities belong to this group.
     */
    private ArrayList<Entity> entities;

    public EntityGroup() {
        entities = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void addEntityToEntities(Entity entity) {
        this.entities.add(entity);
    }
}
