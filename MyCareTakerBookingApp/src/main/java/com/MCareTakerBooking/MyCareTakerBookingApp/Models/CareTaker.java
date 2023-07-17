package com.MCareTakerBooking.MyCareTakerBookingApp.Models;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Abstract.User;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.CareTakerStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.UserGender;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*This is a CareTaker class.
* Caretaker is a type of user, hence inherits properties from User class*/

@NoArgsConstructor
@Getter
@Setter
@Entity // database will have a table of caretaker
@Table(name = "care_taker") // table name
public class CareTaker extends User {
    @Column(name = "fees")
    @NotNull(message = "Fees Per Day can not be null")  // validation
    private Integer fees_per_day;

    @Column(name = "care_taker_status")
    @Enumerated(value = EnumType.STRING)    // Database table will have this property as ENUM
    private CareTakerStatus careTakerStatus;

    @Transient  // this property is not persisted
    private String bio;

    @OneToOne   // A Caretaker can have only one booking at a time
    private Booking booking;

    public CareTaker(Long id, String firstName, String lastName, Integer age, UserGender gender,
                     Address address, String email, String phoneNumber, Integer fees_per_day) {
        super(id, firstName, lastName, age, gender, address, email, phoneNumber);
        this.fees_per_day = fees_per_day;
        this.careTakerStatus = CareTakerStatus.AVAILABLE;
    }

    public void addBio(String bio){
        this.bio = bio;
    }
}
