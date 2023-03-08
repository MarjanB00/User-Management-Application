package com.logate.UserManagemenApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logate.UserManagemenApplication.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {
    private Integer id;
    private String roleName;


}
