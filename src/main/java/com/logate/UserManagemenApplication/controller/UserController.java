package com.logate.UserManagemenApplication.controller;


import com.logate.UserManagemenApplication.configuration.NotFoundException;
import com.logate.UserManagemenApplication.configuration.UserRegisterCommandValidator;
import com.logate.UserManagemenApplication.configuration.ValidationExceptions;
import com.logate.UserManagemenApplication.dto.UserRegisterDTO;
import com.logate.UserManagemenApplication.dto.UsersDTO;
import com.logate.UserManagemenApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRegisterCommandValidator userRegisterCommandValidator;
    private final UserService userService;


    @PostMapping(value = "api/user/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterDTO userRegister) throws ValidationExceptions{

        Errors validationError = new BeanPropertyBindingResult(userRegister, "userRegister");
        ValidationUtils.invokeValidator(userRegisterCommandValidator, userRegister, validationError);


        if (validationError.hasErrors()) {
            throw new ValidationExceptions("Register user validation failed!", validationError);
        }
        userService.register(userRegister);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/api/user/delete/{username}")
    public  ResponseEntity<Void> deleteUserByUsername(@PathVariable String username) throws NotFoundException {

        userService.deleteByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/user/update")
    public  ResponseEntity<Void> updateUser(@RequestBody UserRegisterDTO userDTO,
                                            @RequestParam String username) throws NotFoundException {
        userService.update(userDTO, username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "api/user/get/{kompanija}")
    public ResponseEntity<List <UsersDTO>> getByCompany(@PathVariable String kompanija) throws NotFoundException {
        List <UsersDTO> usersDTOS = userService.getAllUsersByCompany(kompanija);
        return new ResponseEntity<>(usersDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "api/user/get/deactivated")
    public ResponseEntity<List<UsersDTO>> getByDeactive(){
        List <UsersDTO> users = userService.getAllDeactiveUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "api/user/get/userbydate")
    public ResponseEntity<List<UsersDTO>> getByDate(@RequestParam String date){
        List<UsersDTO> users = userService.getAllByDate(date);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
