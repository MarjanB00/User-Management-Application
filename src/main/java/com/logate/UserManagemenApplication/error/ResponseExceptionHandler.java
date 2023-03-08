package com.logate.UserManagemenApplication.error;

import com.logate.UserManagemenApplication.configuration.NotFoundException;
import com.logate.UserManagemenApplication.configuration.ValidationExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationExceptions.class)
    public ResponseEntity<ErrorDTO> handleValidationException(ValidationExceptions e)
    {
        List<FieldErrorDTO> customFieldErrors = new ArrayList<>();

        Errors errors = e.getErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors)
        {
            FieldErrorDTO fieldErrorDTO = new FieldErrorDTO(
                    fieldError.getField(),
                    fieldError.getCode(),
                    fieldError.getDefaultMessage()
            );
            customFieldErrors.add(fieldErrorDTO);
        }

        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), customFieldErrors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException e){

        List<FieldErrorDTO> customFieldErrors = new ArrayList<>();


       List<FieldErrorDTO>  fieldErrors = Collections.singletonList(e.getErrors());


        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(),  fieldErrors);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}