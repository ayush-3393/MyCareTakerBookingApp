package com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/*This class holds the attributes of Medicine*/
@AllArgsConstructor
@Getter
@Setter
public class Medicine {
    private String name;
    private String dosage;
    private LocalDate date;
}
