package com.MCareTakerBooking.MyCareTakerBookingApp.Models.Abstract;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.UserGender;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers.Address;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

/*
* This is an abstract User class which has common attributes for every type of user.
* Using Lombok for Constructor, Getters and Setters
*/
@AllArgsConstructor
@NoArgsConstructor  // No args constructor is required by the JPA
@Getter
@Setter
@MappedSuperclass
/*So that the properties are shared across the child classes and no separate table is created for user class*/
public abstract class User {
    @Id // Indicating the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The id is auto generated
    private Long id;

    @Column(name = "first_name")    // defining the column name in the database table
    @NotNull(message = "First Name can not be null")    // validation
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last Name can not be null")
    private String lastName;

    @NotNull(message = "Age can not be null")
    @Range(min = 10, max = 150, message = "Age must be between 1 and 150")  // validation -> value must be in range
    private Integer age;

    @Enumerated(value = EnumType.STRING)    // So that the database table also accepts this property as an ENUM
    private UserGender gender;

    @Embedded   // The attributes of the Address class will be present in every entity. No separate table for Address
    private Address address;

    @NotNull(message = "Email can not be null")
    @Email(message = "Invalid format of the email") // Email validation
    private String email;

    @NotNull(message = "Phone Number can not be null")
    @Column(name = "phone_number")
    private String phoneNumber;
}
