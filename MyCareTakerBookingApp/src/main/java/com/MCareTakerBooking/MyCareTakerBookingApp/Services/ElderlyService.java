package com.MCareTakerBooking.MyCareTakerBookingApp.Services;

import com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions.InvalidResourcesExceptions;
import com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions.ResourceNotFoundException;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Booking;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Elderly;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.BookingStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.CareTakerStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.CareTakerRepository;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.ElderlyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/* This is a service class for Elderly
 *  This contains the main functionality of the elderly
 * */

@Service    // service class of elderly
@AllArgsConstructor
public class ElderlyService {
    private final CareTakerRepository careTakerRepository;
    private final ElderlyRepository elderlyRepository;
    private final BookingService bookingService;
    private final CareTakerService careTakerService;

    // This method fetches the elderly from the database
    public Elderly getElderly(Long elderlyId){
        return elderlyRepository.findById(elderlyId)
                .orElseThrow(()->new ResourceNotFoundException("Elderly not found with id " + elderlyId));
    }

    // This method fetches all the elderly from the database
    public List<Elderly> getAllElderly(){
        if (elderlyRepository.count() == 0){
            throw new ResourceNotFoundException("Elderly list is empty");
        }
        else {
            return elderlyRepository.findAll();
        }
    }

    // This method creates an elderly and saves it to the database
    public void createElderly(Elderly elderly){
        if (elderly == null){
            throw new InvalidResourcesExceptions("Invalid Details");
        }
        elderlyRepository.save(elderly);
    }

    // This method fetches all the caretakers that are in the same city as that of elderly and are available
    // This is a custom method that uses the caretaker repository
    public List<CareTaker> getAvailableCareTakersByCity(String city){
        return careTakerRepository.findByAddressCityAndCareTakerStatus(city, CareTakerStatus.AVAILABLE);
    }

    // This method books a caretaker for the elderly and creates a booking and saves the booking in the database.
    public Booking bookACareTaker(Long elderlyId, Long careTakerId, LocalDate startDate, Integer duration){
        Elderly elderly = getElderly(elderlyId);
        CareTaker careTaker = careTakerService.getCareTaker(careTakerId);
        Booking booking = new Booking();
        booking.setElderly(elderly);
        booking.setCareTaker(careTaker);
        booking.setStartDate(startDate);
        booking.setDuration(duration);
        Integer fare = careTaker.getFees_per_day() * duration;
        booking.setTotal_fees(fare);
        booking.setBookingStatus(BookingStatus.PENDING);
        return bookingService.createBooking(booking);
    }

    // This method deletes an elderly from the database
    public void deleteElderly(Long elderlyId) {
        Elderly elderly = getElderly(elderlyId);
        elderlyRepository.delete(elderly);
    }
}
