package com.logate.UserManagemenApplication.mapper;

import com.logate.UserManagemenApplication.dto.GradDTO;
import com.logate.UserManagemenApplication.entity.Grad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradMapper {

    Grad convertToEntity(GradDTO gradDTO);

    GradDTO convertToDTO(Grad grad);

    List<GradDTO> convertListToDTO(List<Grad> grad);
}
