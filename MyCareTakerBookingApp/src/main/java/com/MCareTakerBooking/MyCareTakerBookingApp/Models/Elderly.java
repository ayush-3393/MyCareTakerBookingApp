package com.MCareTakerBooking.MyCareTakerBookingApp.Models;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Abstract.User;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.UserGender;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers.Address;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers.Medicine;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*This is an Elderly class
* Elderly is a type of user, hence inherits attributes from User class
*/

@NoArgsConstructor
@Getter
@Entity // So that the database will have a table of Elderly
@Table(name = "elderly")    // defining the table name
public class Elderly extends User {
    @Transient  // The property will not be persisted
    private List<String> list_of_diseases = new ArrayList<>();

    @Transient
    private List<Medicine> list_of_medicines = new ArrayList<>();

    @Transient
    private String expectations_from_caretaker;

    @OneToOne   // one to one cardinality, signifying that an elderly can have only one booking at a time
    private Booking booking;

    // constructor
    public Elderly(Long id, String firstName, String lastName,
                   Integer age, UserGender gender, Address address, String email, String phoneNumber) {
        super(id, firstName, lastName, age, gender, address, email, phoneNumber);
    }

    public void addDisease(String disease){
        this.list_of_diseases.add(disease);
    }

    public void addMedicine(Medicine medicine){
        this.list_of_medicines.add(medicine);
    }

    public void setExpectations(String details){
        this.expectations_from_caretaker = details;
    }

}
