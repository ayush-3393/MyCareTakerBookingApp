package com.MCareTakerBooking.MyCareTakerBookingApp.Controllers;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Booking;
import com.MCareTakerBooking.MyCareTakerBookingApp.Services.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*This is a controller class for the booking.
* A Controller class handles the http request coming from the frontend*/
@RestController // The controller class for the booking
@AllArgsConstructor
@RequestMapping("/booking") // Maps all the request to "/booking"
public class BookingController {

    private final BookingService bookingService;

    // This method creates a booking using the booking services
    @PostMapping    // Handles POST request
    public ResponseEntity<Booking> createABooking(@Valid @RequestBody Booking booking){
        bookingService.createBooking(booking);
        return ResponseEntity.ok(booking);
    }

    // This method fetches a booking by its id, using the booking services
    @GetMapping("/{bookingId}") // Handles the GET request (/booking/{bookingId})
    public ResponseEntity<Booking> getABookingWithId(@PathVariable Long bookingId){
        Booking booking = bookingService.getBooking(bookingId);
        return ResponseEntity.ok(booking);
    }

}
