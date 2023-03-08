package com.logate.UserManagemenApplication.repository;

import com.logate.UserManagemenApplication.entity.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradRepository extends JpaRepository <Grad, Integer>{

    @Query(value = "select grad from Grad grad")
    List<Grad> getAll();

    Grad findByImeGrada(String gradRodjenja);
}
