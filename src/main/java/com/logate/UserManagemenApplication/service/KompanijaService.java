package com.logate.UserManagemenApplication.service;

import com.logate.UserManagemenApplication.controller.KompanijaController;
import com.logate.UserManagemenApplication.dto.KompanijaDTO;
import com.logate.UserManagemenApplication.entity.Kompanija;
import com.logate.UserManagemenApplication.mapper.KompanijaMapper;
import com.logate.UserManagemenApplication.repository.KompanijaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KompanijaService {

    private final KompanijaRepository kompanijaRepository;
    private final KompanijaMapper kompanijaMapper;

    public List<KompanijaDTO> getAll() {
        List<Kompanija> kompanijaList = kompanijaRepository.getAll();
        return kompanijaMapper.convertListToDTO(kompanijaList);
    }
}
