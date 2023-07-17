package com.MCareTakerBooking.MyCareTakerBookingApp.Repositories;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.CareTakerStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//@DataJpaTest
// annotation is used to configure the test with an in-memory H2 database and the necessary Spring Data JPA components.
class CareTakerRepositoryTest {
    @Autowired
    private CareTakerRepository careTakerRepository;

    @Test
    void testFindByAddressCityAndCareTakerStatus() {
        // Creating some caretakers
//        CareTaker careTaker1 = new CareTaker();
//        careTaker1.setAge(25);
//        Address address1 = new Address();
//        address1.setAddressLine("home1");
//        address1.setCity("Bhopal");
//        address1.setState("M.P.");
//        address1.setPinCode(0000003);
//        careTaker1.setAddress(address1);
//        careTaker1.setFirstName("young1");
//        careTaker1.setLastName("young1");
//        careTaker1.setFees_per_day(1000);
//        careTaker1.setEmail("care1@gmail.com");
//        careTaker1.setCareTakerStatus(CareTakerStatus.AVAILABLE);
//        careTaker1.setPhoneNumber("999999999999");
//        careTakerRepository.save(careTaker1);
//
//        CareTaker careTaker2 = new CareTaker();
//        careTaker2.setAge(30);
//        Address address2 = new Address();
//        address2.setAddressLine("home2");
//        address2.setCity("Bhopal");
//        address2.setState("M.P.");
//        address2.setPinCode(0000004);
//        careTaker2.setAddress(address2);
//        careTaker2.setFirstName("young2");
//        careTaker2.setLastName("young2");
//        careTaker2.setFees_per_day(2000);
//        careTaker2.setPhoneNumber("888888888888");
//        careTaker2.setEmail("care2@gmail.com");
//        careTaker2.setCareTakerStatus(CareTakerStatus.UNAVAILABLE);
//        careTakerRepository.save(careTaker2);
//
//        CareTaker careTaker3 = new CareTaker();
//        careTaker3.setAge(35);
//        Address address3 = new Address();
//        address3.setAddressLine("home3");
//        address3.setCity("Indore");
//        address3.setState("M.P.");
//        address3.setPinCode(0000005);
//        careTaker3.setAddress(address3);
//        careTaker3.setFirstName("young3");
//        careTaker3.setLastName("young3");
//        careTaker3.setFees_per_day(3000);
//        careTaker3.setPhoneNumber("7777777");
//        careTaker3.setEmail("care3@gmail.com");
//        careTaker3.setCareTakerStatus(CareTakerStatus.AVAILABLE);
//        careTakerRepository.save(careTaker3);
//
//        List<CareTaker> actualResult = careTakerRepository
//                .findByAddressCityAndCareTakerStatus("Bhopal", CareTakerStatus.AVAILABLE);
//
//        // expected size of the list should be 1
//        int expectedSize = 1;
//        int actualSize = actualResult.size();
//        assertEquals(expectedSize, actualSize);
//
//        // can also verify if we got the same object
//        assertEquals(careTaker1, actualResult.get(0));

    }
}