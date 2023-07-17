package com.MCareTakerBooking.MyCareTakerBookingApp.Services;

import com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions.InvalidResourcesExceptions;
import com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions.ResourceNotFoundException;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.CareTakerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/* This is a service class for Caretaker
 *  This contains the main functionality of the caretakers
 * */

@Service
@AllArgsConstructor
public class CareTakerService {

    private CareTakerRepository careTakerRepository;

    // This method fetches the caretaker from the database by id
    public CareTaker getCareTaker(Long careTakerId){
        return careTakerRepository.findById(careTakerId)
                .orElseThrow(()-> new ResourceNotFoundException("Caretaker not found with id" + careTakerId));
    }

    // This method creates a caretaker and saves it to the database
    public void createCareTaker(CareTaker careTaker){
        if (careTaker == null){
            throw new InvalidResourcesExceptions("Invalid details");
        }
        careTakerRepository.save(careTaker);
    }

    // This method deletes the caretaker present in the database
    public void deleteCareTaker(Long careTakerId) {
        CareTaker careTaker = getCareTaker(careTakerId);
        careTakerRepository.delete(careTaker);
    }
}
