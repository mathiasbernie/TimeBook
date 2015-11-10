package com.example.mathias.timebook.BookingModel;

import java.util.Date;

/**
 * Created by Niklas on 2015-11-09.
 *
 * This class is responsible for Booking objects.
 */
public class Booking {

    private int id;
    private String description;
    private Date starttime;
    private Date endtime;
    private Customer customer;
    private String activity_owner;

    public Booking(){
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
