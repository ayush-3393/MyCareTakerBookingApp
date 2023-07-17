package com.MCareTakerBooking.MyCareTakerBookingApp.Repositories;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.CareTakerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*Caretaker repository.
 * Extending JPA repository provided by SpringBoot
 * Helps to perform database operations on entities*/
@Repository
public interface CareTakerRepository extends JpaRepository<CareTaker, Long> {
    List<CareTaker> findByAddressCityAndCareTakerStatus(String city, CareTakerStatus status);
}
