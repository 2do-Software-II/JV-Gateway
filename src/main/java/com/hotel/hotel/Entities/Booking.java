package com.hotel.hotel.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {
    private String id;
    private String date;
    private String time;
    private String status;
    private String checkIn;
    private String checkOut;
    private float prePaid;
    private float fullPayment;
    private String paymentMethod;
    private String startDate;
    private String endDate;
    private Room room;
    private Customer customer;
}
