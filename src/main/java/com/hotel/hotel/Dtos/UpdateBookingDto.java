package com.hotel.hotel.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBookingDto {
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
}
