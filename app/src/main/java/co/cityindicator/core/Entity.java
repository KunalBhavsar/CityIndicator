package co.cityindicator.core;

import java.util.ArrayList;

/**
 * Contains entity related properties.
 * Created by Kunal Bhavsar on 27/1/16.
 */
public class Entity extends Base {

    /**
     * Name of the entity.
     */
    private String name;
    /**
     * Extra details of the entity if any, not mandatory.
     */
    private String details;
    /**
     * Date of birth of the entity.
     */
    private long dob;
    /**
     * Visibility of the entity. If private details will not be shown to others.
     */
    private boolean privateEntity;
    /**
     * Set of contacts related to the entity object.
     */
    private ArrayList<Contact> contacts;
    /**
     * Set of cities to which entity belongs.
     */
    private ArrayList<City> cities;
    /**
     * Set of ratings given to the this entity by other entities.
     */
    private ArrayList<Rating> ratings;

    public Entity() {
        contacts = new ArrayList<>();
        cities = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public boolean isPrivateEntity() {
        return privateEntity;
    }

    public void setPrivateEntity(boolean privateEntity) {
        this.privateEntity = privateEntity;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public void addContactToContacts(Contact contact) {
        this.contacts.add(contact);
    }

    public void addCityToCities(City city) {
        this.cities.add(city);
    }

    public void addRatingToRatings(Rating rating) {
        this.ratings.add(rating);
    }
}
