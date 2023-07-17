package com.MCareTakerBooking.MyCareTakerBookingApp.Controllers;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Booking;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Services.BookingService;
import com.MCareTakerBooking.MyCareTakerBookingApp.Services.CareTakerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/*This is a controller class for the Caretaker.
 * A Controller class handles the http request coming from the frontend*/
@RestController // To identify this as a controller class
@AllArgsConstructor
@RequestMapping("/caretaker")   // maps all the request to "/caretaker"
public class CareTakerController {

    private final BookingService bookingService;
    private final CareTakerService careTakerService;

    // This method creates a caretaker
    @PostMapping
    public ResponseEntity<String>createACareTaker(@Valid CareTaker careTaker){
        careTakerService.createCareTaker(careTaker);
        return ResponseEntity.ok("Caretaker created successfully");
    }

    // This method fetches a caretaker by its id
    @GetMapping("/{careTakerId}")
    public ResponseEntity<CareTaker> getACareTakerWithId(@PathVariable Long careTakerid){
        CareTaker careTaker = careTakerService.getCareTaker(careTakerid);
        return ResponseEntity.ok(careTaker);
    }


    // This method fetches all the pending booking for a caretaker
    @GetMapping("/{careTakerId}/bookings/pending")
    public ResponseEntity<List<Booking>> getPendingBookings(@PathVariable Long careTakerId){
        List<Booking> pendingBookings = bookingService.getPendingBookingsForCareTaker(careTakerId);
        return ResponseEntity.ok(pendingBookings);
    }

    // This method accepts the booking
    @PostMapping("/bookings/{bookingId}/accept")
    public ResponseEntity<Booking> acceptBooking(@PathVariable Long bookingId){
        Booking booking = bookingService.acceptBookingRequest(bookingId);
        return ResponseEntity.ok(booking);
    }


    // This method declines the booking
    @PostMapping("/bookings/{bookingId}/decline")
    public ResponseEntity<String> declineBooking(@PathVariable Long bookingId){
        bookingService.declineBookingRequest(bookingId);
        return ResponseEntity.ok("Successfully Declined");
    }

    // This method deletes a caretaker with the given id
    @DeleteMapping("/{careTakerId}")
    public ResponseEntity<HttpStatus> deleteACareTaker(@PathVariable Long careTakerId){
        careTakerService.deleteCareTaker(careTakerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
