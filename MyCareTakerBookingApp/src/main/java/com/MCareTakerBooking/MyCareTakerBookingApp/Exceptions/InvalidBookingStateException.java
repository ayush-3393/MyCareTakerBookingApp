package com.MCareTakerBooking.MyCareTakerBookingApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidBookingStateException extends RuntimeException{
    public InvalidBookingStateException(String message) {
        super(message);
    }
}
