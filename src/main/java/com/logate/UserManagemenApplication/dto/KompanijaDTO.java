package com.logate.UserManagemenApplication.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KompanijaDTO {
    private Integer id;
    private String imeKompanije;
    private String adresa;
    private String telefonskiBroj;
    private String website;
}
