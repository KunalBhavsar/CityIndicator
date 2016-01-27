package co.cityindicator.core;

/**
 * Contain particular train stop related properties.
 * Created by Kunal Bhavsar on 27/1/16.
 */
public class TrainStop extends  Base {

    /**
     * Train to which this stop related.
     */
    private Train train;
    /**
     * City to which this stop related.
     */
    private City city;
    /**
     * Arriaval time in milliseconds.
     */
    private long arriavalTime;
    /**
     * Departure time in milliseconds;
     */
    private long departureTime;

    /**
     * Day's of the week, on which this train will halt at particular city.
     */
    private boolean sunday;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getArriavalTime() {
        return arriavalTime;
    }

    public void setArriavalTime(long arriavalTime) {
        this.arriavalTime = arriavalTime;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }
}
