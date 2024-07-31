package org.rothurtech.usermanagement.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {
    private HttpStatus httpStatus;

    public UserException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
