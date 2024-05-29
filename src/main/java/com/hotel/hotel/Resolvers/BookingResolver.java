package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.hotel.hotel.Dtos.CreateBookingDto;
import com.hotel.hotel.Dtos.UpdateBookingDto;
import com.hotel.hotel.Entities.Booking;
import com.hotel.hotel.Services.BookingService;

@Controller
public class BookingResolver {

    @Autowired
    private BookingService bookingService;

    @QueryMapping()
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }

    @QueryMapping()
    public Booking getOneBooking(@Argument String id) {
        return bookingService.getOne(id);
    }

    @QueryMapping()
    public List<Booking> getAllBookingsBy(@Argument String attr, @Argument String value) {
        return bookingService.getAllBookingsBy(attr, value);
    }

    @MutationMapping()
    public Booking createBooking(@Argument CreateBookingDto createBookingDto) {
        return bookingService.create(createBookingDto);
    }

    @MutationMapping()
    public Booking updateBooking(@Argument String id, @Argument UpdateBookingDto updateBookingDto) {
        return bookingService.update(id, updateBookingDto);
    }

    @MutationMapping()
    public void deleteBooking(@Argument String id) {
        bookingService.delete(id);
    }

}
