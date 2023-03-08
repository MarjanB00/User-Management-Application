package com.logate.UserManagemenApplication.configuration;

import com.logate.UserManagemenApplication.dto.UserRegisterDTO;
import com.logate.UserManagemenApplication.service.UserService;

import liquibase.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        validateUsername(userRegister.getUsername(), errors);
        validatePassword(userRegister.getPassword(), errors);

    }

    private void validateEmail(String email, Errors errors) {
        boolean doesUserWithEmailExists= userService.existsByEmail(email);
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()){
            errors.rejectValue("email", "email.not-valid", "Email " + email + " is not a valid email address");
            return;
        }
        if (email.chars().filter(chars -> chars == '@').count()!=1){
            errors.rejectValue("email", "email.not-valid", "Email " + " must contain only one @ character" );
            return;
        }
        if(doesUserWithEmailExists){
            errors.rejectValue("email", "email.already-exists", "User with email " + email + " already exists!");
        }

    }

    private void validateUsername(String username, Errors errors){
        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[A-Z].*";
        String smallalphaRegex = ".*[a-z].*";

        char[] chars = username.toCharArray();
        for (char c: chars
             ) {
            boolean a = String.valueOf(c).matches(numRegex);
            boolean b = String.valueOf(c).matches(alphaRegex);
            boolean d = String.valueOf(c).matches(smallalphaRegex);
            boolean e = String.valueOf(c).matches("\\.");
            if (!a && !b && !d && !e){
                errors.rejectValue("username", "username.not-valid", "username " + " contains illegal characters");
                return;
            }
        }
    }

    private void validatePassword(String password, Errors errors){
        String smallalphaRegex = ".*[a-z].*";
        String alphaRegex = ".*[A-Z].*";
        String numRegex   = ".*[0-9].*";
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(password);

        if (password == null){
            errors.rejectValue("password", "password.required", "password is required");
            return;
        }
        if (password.trim().equals("")){
            errors.rejectValue("password","password.empty", "Password is empty");
        }

        if (password.length()<8){
            errors.rejectValue("password", "password.length-not-valid", "password is too short");
            return;
            }
        if(!password.matches(smallalphaRegex)){
            errors.rejectValue("password", "password.small-letters-not-found", "password must contain small letters");
            return;
        }
        if (!password.matches(alphaRegex)){
            errors.rejectValue("password", "password.capital-letters-not-found", "password must contain capital letters");
            return;
        }
        if (!password.matches(numRegex)){
            errors.rejectValue("password", "password.numbers-not-found", "password must contain numbers");
            return;
        }
        if (!hasSpecial.find()){
            errors.rejectValue("password", "password.spacial-car-not-found", "password must contain special character");
        }

    }

}
