package com.logate.UserManagemenApplication.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;

@Getter
@RequiredArgsConstructor
public class ValidationExceptions extends Exception {

    private final String message;
    private final Errors errors;

}
