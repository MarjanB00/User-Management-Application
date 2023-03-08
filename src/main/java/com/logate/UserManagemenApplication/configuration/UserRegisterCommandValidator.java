package com.logate.UserManagemenApplication.configuration;

import com.logate.UserManagemenApplication.dto.UserRegisterDTO;
import com.logate.UserManagemenApplication.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserRegisterCommandValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserRegisterDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserRegisterDTO userRegister = (UserRegisterDTO) target;

        validateEmail(userRegister.getEmail(), errors);


    }

    private void validateEmail(String email, Errors errors) {
        boolean doesUserWithEmailExists= userService.existsByEmail(email);
        if(doesUserWithEmailExists){
            errors.rejectValue("email", "email.already-exists", "User with email " + email + " already exists!");
        }
    }
}
