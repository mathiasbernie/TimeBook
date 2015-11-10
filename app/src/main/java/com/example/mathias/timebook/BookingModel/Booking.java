package com.example.mathias.timebook.BookingModel;

import java.util.Date;

/**
 * Created by Niklas on 2015-11-09.
 *
 * This class is responsible for Booking objects.
 */
public class Booking {

    private int id;

    public String getActivity_owner() {
        return activity_owner;
    }

    public void setActivity_owner(String activity_owner) {
        this.activity_owner = activity_owner;
    }

    private String description;
    private String starttime;
    private String endtime;
    private Customer customer;
    private String activity_owner;

    public Booking(){
    }

    public Booking(String description, String starttime, String endtime, Customer customer, String activity_owner){
        this.description = description;
        this.starttime = starttime;
        this.endtime = endtime;
        this.customer = customer;
        this.activity_owner = activity_owner;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
