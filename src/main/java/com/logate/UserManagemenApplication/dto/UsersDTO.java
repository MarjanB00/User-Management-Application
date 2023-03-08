package com.logate.UserManagemenApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UsersDTO {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String ime;
    private String prezime;
    private String pol;
    private LocalDate datumRodjenja;
    private GradDTO gradRodjenja;
    private LocalDate datumKreiranja;
    private boolean aktivan;
    private KompanijaDTO kompanija;
    private Set<RoleDTO> roles = new HashSet<>();
}
