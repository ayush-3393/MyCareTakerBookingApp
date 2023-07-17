package com.MCareTakerBooking.MyCareTakerBookingApp.DatabaseDataSeeder;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Elderly;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Enums.CareTakerStatus;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Helpers.Address;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.BookingRepository;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.CareTakerRepository;
import com.MCareTakerBooking.MyCareTakerBookingApp.Repositories.ElderlyRepository;
import com.MCareTakerBooking.MyCareTakerBookingApp.Services.CareTakerService;
import com.MCareTakerBooking.MyCareTakerBookingApp.Services.ElderlyService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final ElderlyRepository elderlyRepository;
    private final CareTakerRepository careTakerRepository;
    private final ElderlyService elderlyService;
    private final CareTakerService careTakerService;
//    private final BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
//        elderlyRepository.deleteAll();
//        careTakerRepository.deleteAll();
//        bookingRepository.deleteAll();

        if (elderlyRepository.count() == 0){
            Elderly elderly1 = new Elderly();
            elderly1.setAge(65);
            Address address = new Address();
            address.setAddressLine("add1");
            address.setCity("Bhopal");
            address.setState("M.P.");
            address.setPinCode(111111);
            elderly1.setAddress(address);
            elderly1.setFirstName("old1");
            elderly1.setLastName("old1");
            elderly1.setEmail("email1@gmail.com");
            elderly1.setPhoneNumber("0000000");
//            elderlyRepository.save(elderly1);
            elderlyService.createElderly(elderly1);

            Elderly elderly2 = new Elderly();
            elderly2.setAge(79);
            Address address2 = new Address();
            address2.setAddressLine("add2");
            address2.setCity("Indore");
            address2.setState("M.P.");
            address2.setPinCode(222222);
            elderly2.setAddress(address2);
            elderly2.setFirstName("old2");
            elderly2.setLastName("old2");
            elderly2.setEmail("email2@gmail.com");
            elderly2.setPhoneNumber("11111111");
//            elderlyRepository.save(elderly2);
            elderlyService.createElderly(elderly2);

            Elderly elderly3 = new Elderly();
            elderly3.setAge(75);
            Address address3 = new Address();
            address3.setAddressLine("add3");
            address3.setCity("Ujjain");
            address3.setState("M.P.");
            address3.setPinCode(333333);
            elderly3.setAddress(address3);
            elderly3.setFirstName("old3");
            elderly3.setLastName("old3");
            elderly3.setEmail("email3@gmail.com");
            elderly3.setPhoneNumber("333333333");
//            elderlyRepository.save(elderly3);
            elderlyService.createElderly(elderly3);
        }

        if (careTakerRepository.count() == 0){
            CareTaker careTaker1 = new CareTaker();
            careTaker1.setAge(25);
            Address address1 = new Address();
            address1.setAddressLine("home1");
            address1.setCity("Bhopal");
            address1.setState("M.P.");
            address1.setPinCode(0000003);
            careTaker1.setAddress(address1);
            careTaker1.setFirstName("young1");
            careTaker1.setLastName("young1");
            careTaker1.setFees_per_day(1000);
            careTaker1.setEmail("care1@gmail.com");
            careTaker1.setCareTakerStatus(CareTakerStatus.AVAILABLE);
//            careTakerRepository.save(careTaker1);
            careTaker1.setPhoneNumber("999999999999");
            careTakerService.createCareTaker(careTaker1);

            CareTaker careTaker2 = new CareTaker();
            careTaker2.setAge(30);
            Address address2 = new Address();
            address2.setAddressLine("home2");
            address2.setCity("Bhopal");
            address2.setState("M.P.");
            address2.setPinCode(0000004);
            careTaker2.setAddress(address2);
            careTaker2.setFirstName("young2");
            careTaker2.setLastName("young2");
            careTaker2.setFees_per_day(2000);
            careTaker2.setPhoneNumber("888888888888");
            careTaker2.setEmail("care2@gmail.com");
            careTaker2.setCareTakerStatus(CareTakerStatus.UNAVAILABLE);
//            careTakerRepository.save(careTaker2);
            careTakerService.createCareTaker(careTaker2);

            CareTaker careTaker3 = new CareTaker();
            careTaker3.setAge(35);
            Address address3 = new Address();
            address3.setAddressLine("home3");
            address3.setCity("Indore");
            address3.setState("M.P.");
            address3.setPinCode(0000005);
            careTaker3.setAddress(address3);
            careTaker3.setFirstName("young3");
            careTaker3.setLastName("young3");
            careTaker3.setFees_per_day(3000);
            careTaker3.setPhoneNumber("7777777");
            careTaker3.setEmail("care3@gmail.com");
            careTaker3.setCareTakerStatus(CareTakerStatus.AVAILABLE);
//            careTakerRepository.save(careTaker3);
            careTakerService.createCareTaker(careTaker3);

            CareTaker careTaker4 = new CareTaker();
            careTaker4.setAge(40);
            Address address4 = new Address();
            address4.setAddressLine("home4");
            address4.setCity("Bhopal");
            address4.setState("M.P.");
            address4.setPinCode(0000006);
            careTaker4.setAddress(address4);
            careTaker4.setFirstName("young4");
            careTaker4.setLastName("young4");
            careTaker4.setFees_per_day(4000);
            careTaker4.setPhoneNumber("6666666666");
            careTaker4.setEmail("care4@gmail.com");
            careTaker4.setCareTakerStatus(CareTakerStatus.AVAILABLE);
//            careTakerRepository.save(careTaker4);
            careTakerService.createCareTaker(careTaker4);


            CareTaker careTaker5 = new CareTaker();
            careTaker5.setAge(50);
            Address address5 = new Address();
            address5.setAddressLine("home5");
            address5.setCity("Bhopal");
            address5.setState("M.P.");
            address5.setPinCode(00000067);
            careTaker5.setAddress(address5);
            careTaker5.setFirstName("young5");
            careTaker5.setLastName("young5");
            careTaker5.setFees_per_day(5000);
            careTaker5.setPhoneNumber("444777788");
            careTaker5.setEmail("care5@gmail.com");
            careTaker5.setCareTakerStatus(CareTakerStatus.AVAILABLE);
//            careTakerRepository.save(careTaker5);
            careTakerService.createCareTaker(careTaker5);
        }


    }
}
