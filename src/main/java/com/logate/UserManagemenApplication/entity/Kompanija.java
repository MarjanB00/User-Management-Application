package com.logate.UserManagemenApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kompanija")
public class Kompanija {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ime_kompanije")
    private String imeKompanije;

    @Column
    private String adresa;

    @Column(name = "telefonski_broj")
    private String telefonskiBroj;

    @Column
    private String website;

    @OneToMany(mappedBy = "kompanija")
    @JsonBackReference
    private List<Users> users = new ArrayList<>();
}

