package com.example.mathias.timebook.BookingModel;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Niklas on 2015-11-09.
 *
 * Object class responsible for holding Customer data.
 */
public class Customer {

    private String phone_number;
    private String name;

    public Customer(){}

    public Customer(String name, String phone_number){
        this.phone_number = phone_number;
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
