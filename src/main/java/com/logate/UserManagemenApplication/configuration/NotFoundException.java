package com.logate.UserManagemenApplication.configuration;

import com.logate.UserManagemenApplication.error.FieldErrorDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;

@Getter
@RequiredArgsConstructor
public class NotFoundException extends Exception {

    private final String message;
    private final FieldErrorDTO errors;
}
