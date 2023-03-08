package com.logate.UserManagemenApplication.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorDTO {

    private String message;
    private List<FieldErrorDTO> errors;

}