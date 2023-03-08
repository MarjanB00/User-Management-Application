package com.logate.UserManagemenApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String ime;
    private String prezime;
    private String pol;
    private LocalDate datumRodjenja;
    private String gradRodjenja;
    private LocalDate datumKreiranja;
    private boolean aktivan;
    private String kompanija;

}
