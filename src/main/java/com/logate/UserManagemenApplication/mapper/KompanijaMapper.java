package com.logate.UserManagemenApplication.mapper;

import com.logate.UserManagemenApplication.dto.KompanijaDTO;
import com.logate.UserManagemenApplication.entity.Kompanija;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KompanijaMapper {

    Kompanija convertToEntity(KompanijaDTO kompanijaDTO);

    KompanijaDTO convertToDTO(Kompanija kompanija);

    List<KompanijaDTO> convertListToDTO(List<Kompanija> kompanija);
}
