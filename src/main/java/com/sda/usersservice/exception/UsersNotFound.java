package com.sda.usersservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsersNotFound extends RuntimeException {

    public UsersNotFound() {
    }

    public UsersNotFound(String message) {
        super(message);
    }

}
