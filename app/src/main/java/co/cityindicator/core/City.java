package co.cityindicator.core;

import java.util.ArrayList;

/**
 * Contain data related to particular city.
 * Created by Kunal Bhavsar on 27/1/16.
 */
public class City extends Base {

    /**
     * Name of the city.
     */
    private String cityName;
    /**
     * Description of the city, if any.
     */
    private String description;
    /**
     * Belongs to supercity eg. City belongs to District, if any
     */
    private City supercity;
    /**
     * Train stops belongs to this city.
     */
    private ArrayList<TrainStop> trainStops;
    /**
     * Public entities belongs to this city.
     */
    private ArrayList<Entity> publicEntities;

    public City() {
        trainStops = new ArrayList<>();
        publicEntities = new ArrayList<>();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getSupercity() {
        return supercity;
    }

    public void setSupercity(City supercity) {
        this.supercity = supercity;
    }

    public ArrayList<TrainStop> getTrainStops() {
        return trainStops;
    }

    public void setTrainStops(ArrayList<TrainStop> trainStops) {
        this.trainStops = trainStops;
    }

    public ArrayList<Entity> getPublicEntities() {
        return publicEntities;
    }

    public void setPublicEntities(ArrayList<Entity> publicEntities) {
        this.publicEntities = publicEntities;
    }

    public void addEntityToPublicEntities(Entity entity) {
        this.publicEntities.add(entity);
    }

    public void addTrainStopToTrainStops(TrainStop trainStop) {
        this.trainStops.add(trainStop);
    }
}
