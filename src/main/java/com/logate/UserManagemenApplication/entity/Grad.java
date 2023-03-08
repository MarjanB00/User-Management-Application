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
@Table(name = "grad")
public class Grad {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ime_grada")
    private String imeGrada;

    @Column(name = "zemlja_rodjenja")
    private String zemljaRodjenja;

    @OneToMany(mappedBy = "gradRodjenja", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Users> users = new ArrayList<>();

}
