package com.logate.UserManagemenApplication.repository;

import com.logate.UserManagemenApplication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {


    boolean existsByEmail(String email);


    void deleteByUsername(String username);

    boolean existsByUsername(String username);

    Users findByUsername(String username);


    @Query(value = "select user from Users user where user.kompanija = kompanija.id and kompanija.imeKompanije = :kompanija")
    List<Users> getAllByCompany(String kompanija);

    @Query(value = "select * from user " +
            "where aktivan = 0", nativeQuery = true)
    List<Users> getAllDeactive();

    @Query(value = "SELECT * FROM user " +
            " WHERE user.datum_kreiranja = :date ", nativeQuery = true)
    List<Users> getByDateofCretion(String date);
}
