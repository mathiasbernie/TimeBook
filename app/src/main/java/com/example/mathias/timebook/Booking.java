package com.example.mathias.timebook;

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
    private ActivityOwner activity_owner;

    public Booking(){}
}
