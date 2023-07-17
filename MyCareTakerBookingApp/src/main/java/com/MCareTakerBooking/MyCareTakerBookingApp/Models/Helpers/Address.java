package com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*This class holds attributes of Address*/
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable // The attributes of the address class will be shared with each entity holding the Address type variable
public class Address {
    private String addressLine;
    private String city;
    private String state;
    private Integer pinCode;
}
