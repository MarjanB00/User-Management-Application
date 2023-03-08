package com.logate.UserManagemenApplication.repository;

import com.logate.UserManagemenApplication.entity.Kompanija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Integer> {

    @Query(value = "select kompanija from Kompanija kompanija")
    List<Kompanija> getAll();

    @Query(value = "select kompanija from Kompanija kompanija where kompanija.imeKompanije = :kompanija")
    Kompanija findByImeKompanije(String kompanija);

    @Query(value = "select kompanija from Kompanija kompanija where kompanija.imeKompanije = :kompanija")
    boolean existsByName(String kompanija);
}
