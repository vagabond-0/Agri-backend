package com.example.Agri.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FarmerException {
    @ResponseStatus(HttpStatus.CONFLICT)
    public static class FarmerAlreadyExistsException extends RuntimeException {
        public FarmerAlreadyExistsException(String message) {
            super(message);
        }
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    public static class InvalidCredentialsException extends RuntimeException {
        public InvalidCredentialsException(String message) {
            super(message);
        }
    }
}
