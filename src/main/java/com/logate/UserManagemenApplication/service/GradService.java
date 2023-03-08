package com.logate.UserManagemenApplication.service;

import com.logate.UserManagemenApplication.dto.GradDTO;
import com.logate.UserManagemenApplication.entity.Grad;
import com.logate.UserManagemenApplication.mapper.GradMapper;
import com.logate.UserManagemenApplication.repository.GradRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradService {

    private final GradMapper gradMapper;
    private final GradRepository gradRepository;

    public List<GradDTO> getAll() {

        List<Grad> gradovi = gradRepository.getAll();
        return gradMapper.convertListToDTO(gradovi);

    }
}
