package com.logate.UserManagemenApplication.mapper;

import com.logate.UserManagemenApplication.dto.RoleDTO;
import com.logate.UserManagemenApplication.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role convertToEntity(RoleDTO roleDTO);

    RoleDTO convertToDTO(Role role);
}
