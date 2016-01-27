package co.cityindicator.core;

import java.util.ArrayList;

/**
 * Contain data related to particular train.
 * Created by Kunal Bhavsar on 27/1/16.
 */
public class Train extends Base {

    //Train direction related constants
    public static final String DIRECTION_UP = "up";
    public static final String DIRECTION_DOWN = "down";

    /**
     * Name of the train.
     */
    private String name;

    /**
     * Number of the train.
     */
    private String number;

    /**
     * Starting from city.
     */
    private City fromCity;

    /**
     * Destination city.
     */
    private City toCity;

    /**
     * Direction it is travelling, whether up or down.
     */
    private String direction;

    /**
     * Train stops of this train.
     */
    private ArrayList<TrainStop> trainStops;

    public Train() {
        trainStops = new ArrayList<>();
    }
    public static String getDirectionUp() {
        return DIRECTION_UP;
    }

    public static String getDirectionDown() {
        return DIRECTION_DOWN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public ArrayList<TrainStop> getTrainStops() {
        return trainStops;
    }

    public void setTrainStops(ArrayList<TrainStop> trainStops) {
        this.trainStops = trainStops;
    }

    public void addTrainStopToTrainStops(TrainStop trainStop) {
        this.trainStops.add(trainStop);
    }
}
