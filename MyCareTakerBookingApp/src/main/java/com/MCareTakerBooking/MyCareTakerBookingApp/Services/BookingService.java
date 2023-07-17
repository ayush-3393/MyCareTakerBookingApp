package com.MCareTakerBooking.MyCareTakerBookingApp.Services;

import com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions.InvalidBookingStateException;
import com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions.ResourceNotFoundException;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Booking;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.BookingStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.CareTakerStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.BookingRepository;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.CareTakerRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* This is a service class for Bookings
*  This contains the main functionality of the Bookings
* */


@Service    // to identify this class as a service
@AllArgsConstructor // from Lombok
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CareTakerRepository careTakerRepository;

    // This method creates a booking using Booking Repository
    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking); // save --> saves the Booking in the booking table
    }

    // This method fetches the booking by its id
    // findById() --> default method provided by JPA
    public Booking getBooking(Long bookingId){
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id" + bookingId));
    }

    // This method fetches all the bookings which are pending for a particular caretaker
    public List<Booking> getPendingBookingsForCareTaker(Long careTakerId){
        return bookingRepository.findByCareTakerIdAndBookingStatus(careTakerId, BookingStatus.PENDING);
    }

    // This method accepts the pending booking
    // After accepting the booking, changes the status of booking to ACCEPTED
    // and changes the status of booked Caretaker to UNAVAILABLE
    public Booking acceptBookingRequest(Long bookingId){
        try {
            Booking booking = getBooking(bookingId);
            if (booking.getBookingStatus() != BookingStatus.PENDING){
                throw new InvalidBookingStateException("Cannot accept this booking");
            }
            booking.setBookingStatus(BookingStatus.ACCEPTED);
            booking.getCareTaker().setCareTakerStatus(CareTakerStatus.UNAVAILABLE);
            return bookingRepository.save(booking);
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFoundException("Booking not found with id " + bookingId);
        }
    }

    // This method declines a pending Booking
    // After declining, the status of the booking changes to DECLINED
    public void declineBookingRequest(Long bookingId){
        try {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(()-> new ResourceNotFoundException("Booking not found with id " + bookingId));
            if (booking.getBookingStatus() != BookingStatus.PENDING){
                throw new InvalidBookingStateException("Cannot decline this booking");
            }
            booking.setBookingStatus(BookingStatus.DECLINED);
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFoundException("Booking not found with id " + bookingId);
        }
    }

    @Scheduled(cron = "0 0 0 * * ?") // Run at midnight every day
    /*The @Scheduled annotation is used in Spring to schedule the execution of methods at specific times or intervals.
    In the given example, the annotation is applied to a method with the cron expression "0 0 0 * * ?".
    The cron expression "0 0 0 * * ?" represents a schedule to run the annotated method at midnight every day.
    */
    // This method ensures that the after a booking has ended, the status of
    // booking changes to FINISHED
    // and the status of caretaker reverts back to AVAILABLE
    // This method is scheduled to run every day.
    // If the present date is after the booking dae + duration, the status change takes effect
    public void updateBookingStatusAndCareTakerStatusAfterEndOfBooking(){
        LocalDate currDate = LocalDate.now();
        List<Booking> bookings = bookingRepository.findByStartDate(currDate);
        for (Booking booking : bookings){
            LocalDate endDate = booking.getStartDate().plusDays(booking.getDuration());
            if (currDate.isAfter(endDate)){
                booking.setBookingStatus(BookingStatus.FINISHED);
                booking.getCareTaker().setCareTakerStatus(CareTakerStatus.AVAILABLE);
            }
        }
        bookingRepository.saveAll(bookings);

        List<CareTaker> careTakers = new ArrayList<>();
        for (Booking booking : bookings) {
            CareTaker careTaker = booking.getCareTaker();
            careTakers.add(careTaker);
        }
        careTakerRepository.saveAll(careTakers);

    }


}
