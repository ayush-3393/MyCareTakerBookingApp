package com.MCareTakerBooking.MyCareTakerBookingApp.Controllers;

import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Booking;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.CareTaker;
import com.MCareTakerBooking.MyCareTakerBookingApp.Models.Elderly;
import com.MCareTakerBooking.MyCareTakerBookingApp.Services.ElderlyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*This is a controller class for the elderly.
 * A Controller class handles the http request coming from the frontend*/

@RestController // To identify this class a controller class
@AllArgsConstructor
@RequestMapping("/elderly") // maps all the request to "/elderly"
public class ElderlyController {

    private final ElderlyService elderlyService;


    // This method creates an elderly
    @PostMapping
    public ResponseEntity<String> createAnElderly(@Valid Elderly elderly){
        elderlyService.createElderly(elderly);
        return ResponseEntity.ok("Elderly created successfully");
    }


    // This method fetches list of all the elderly
    @GetMapping
    public ResponseEntity<List<Elderly>> getAllElderlyList(){
        List<Elderly> list_of_elderly =  elderlyService.getAllElderly();
        return ResponseEntity.ok(list_of_elderly);
    }


    // This method fetches an elderly with the given id
    @GetMapping("/{elderlyId}")
    public ResponseEntity<Elderly> getAnElderly(@PathVariable Long elderlyId){
        Elderly elderly = elderlyService.getElderly(elderlyId);
        return ResponseEntity.ok(elderly);
    }

    // This method fetches all the available caretakers in the same city as of the elderly
    @GetMapping("/{elderlyId}/caretakerlist")
    public ResponseEntity<List<CareTaker>> getAvailableCareTakers(@PathVariable Long elderlyId){
        Elderly elderly = elderlyService.getElderly(elderlyId);
        List<CareTaker> list = elderlyService.getAvailableCareTakersByCity(elderly.getAddress().getCity());
        return ResponseEntity.ok(list);
    }


    // This method books a caretaker for the provided duration and creates a Booking
    @PostMapping("/{id}/caretaker/book")
    public ResponseEntity<Booking> bookCareTaker(@PathVariable("id") Long elderlyId,
                                                 @Valid @RequestParam("careTakerId") Long careTakerId,
                                                 @Valid @RequestParam("startDate")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                 @Valid @RequestParam("duration") Integer duration){
        Booking booking = elderlyService.bookACareTaker(elderlyId, careTakerId, startDate, duration);
        return ResponseEntity.ok(booking);
    }


    // This method deletes an elderly with the given id
    @DeleteMapping("/{elderlyId}")
    public ResponseEntity<HttpStatus> deleteAnElderly(@PathVariable Long elderlyId){
        elderlyService.deleteElderly(elderlyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
