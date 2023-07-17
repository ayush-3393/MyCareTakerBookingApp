package com.MCareTakerBooking.MyCareTakerBookingApp.Repositories;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Elderly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Elderly repository.
 * Extending JPA repository provided by SpringBoot
 * Helps to perform database operations on entities*/

@Repository
public interface ElderlyRepository extends JpaRepository<Elderly, Long> {
}
