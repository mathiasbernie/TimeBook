package com.example.mathias.timebook;

/**
 * Created by Niklas on 2015-11-09.
 *
 * Factory class for Bookings.
 */
public class BookingFactory {

    public static Booking CreateBooking(){
        return new Booking();
    }

}
