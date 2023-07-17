package com.MCareTakerBooking.MyCareTakerBookingApp.Models;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/*This is a Booking Class.*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // Booking will have a table in database
@Table(name = "booking")    // table name
public class Booking {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id is auto generated
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToOne   // There can be only one booking per elderly at a time
    private Elderly elderly;

    @OneToOne   // can can be only one booking per caretaker at a time
    private CareTaker careTaker;

    @NotNull(message = "Start Date can not be null")
    @FutureOrPresent(message = "Date can not be in the past")   // Date validation
    private LocalDate startDate;

    @NotNull(message = "Duration can not be null")
    private Integer duration;

    private Integer total_fees;
    @Enumerated(value = EnumType.STRING)    // table will have this column as ENUM.
    private BookingStatus bookingStatus;
}
