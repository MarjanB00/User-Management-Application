package com.logate.UserManagemenApplication.controller;

import com.logate.UserManagemenApplication.dto.GradDTO;
import com.logate.UserManagemenApplication.service.GradService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class GradController {

    private final GradService gradService;

    @GetMapping(value = "/api/grad/svigradovi")
    public ResponseEntity<List<GradDTO>> getAllCitys() {
        List<GradDTO> gradDTO = gradService.getAll();
        return new ResponseEntity<>(gradDTO, HttpStatus.OK);
    }

}
