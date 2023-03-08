package com.logate.UserManagemenApplication.controller;


import com.logate.UserManagemenApplication.dto.KompanijaDTO;
import com.logate.UserManagemenApplication.service.KompanijaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class KompanijaController  {

    private final KompanijaService kompanijaService;

    @GetMapping(value = "api/kompanija/svekompanije")
    public ResponseEntity<List<KompanijaDTO>> getAll(){
        List<KompanijaDTO> kompanijaDTO = kompanijaService.getAll();
        return new ResponseEntity<>(kompanijaDTO, HttpStatus.OK);
    }
}
