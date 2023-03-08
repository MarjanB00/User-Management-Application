package com.logate.UserManagemenApplication.mapper;

import com.logate.UserManagemenApplication.dto.UserRegisterDTO;
import com.logate.UserManagemenApplication.dto.UsersDTO;
import com.logate.UserManagemenApplication.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users convertToEntity(UsersDTO usersDTO);

    UsersDTO convertToDTO(Users users);

    @Mapping(target = "gradRodjenja", ignore = true)
    @Mapping(target = "kompanija", ignore = true)
    Users convertToEntityReg(UserRegisterDTO userRegister);


    List<UsersDTO> convertToListDTO(List<Users> users);
}
