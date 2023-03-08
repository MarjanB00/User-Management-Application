package com.logate.UserManagemenApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class Users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String pol;

    @Column(name = "datum_rodjenja")
    private java.sql.Date datumRodjenja;

    @ManyToOne
    @JoinColumn(name = "grad_rodjenja")
    @JsonManagedReference
    private Grad gradRodjenja;

    @Column(name = "datum_kreiranja")
    private java.sql.Date datumKreiranja;

    @Column
    private boolean aktivan;

    @ManyToOne
    @JoinColumn(name = "kompanija_id")
    @JsonManagedReference
    private Kompanija kompanija;

    @ManyToMany(cascade = CascadeType.ALL) // LAZY
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

}
