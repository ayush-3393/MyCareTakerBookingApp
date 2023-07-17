package com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidResourcesExceptions extends RuntimeException{
    public InvalidResourcesExceptions(String message) {
        super(message);
    }
}
