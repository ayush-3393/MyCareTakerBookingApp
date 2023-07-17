package com.MCareTakerBooking.MyCareTakerBookingApp.Repositories;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Booking;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/*Booking repository.
* Extending JPA repository provided by SpringBoot
* Helps to perform database operations on entities*/

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    /*While writing the functions, need to follow the writing conventions for method names*/
    List<Booking> findByCareTakerIdAndBookingStatus(Long careTakerId, BookingStatus bookingStatus);

    List<Booking> findByStartDate(LocalDate currDate);
}
