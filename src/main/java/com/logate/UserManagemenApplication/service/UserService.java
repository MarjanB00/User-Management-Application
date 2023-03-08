package com.logate.UserManagemenApplication.service;

import com.logate.UserManagemenApplication.configuration.NotFoundException;

import com.logate.UserManagemenApplication.dto.UserRegisterDTO;
import com.logate.UserManagemenApplication.dto.UsersDTO;
import com.logate.UserManagemenApplication.entity.Users;
import com.logate.UserManagemenApplication.error.FieldErrorDTO;
import com.logate.UserManagemenApplication.mapper.UserMapper;
import com.logate.UserManagemenApplication.repository.GradRepository;
import com.logate.UserManagemenApplication.repository.KompanijaRepository;
import com.logate.UserManagemenApplication.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final KompanijaRepository kompanijaRepository;
    private final GradRepository gradRepository;
    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public void register(UserRegisterDTO userRegister) {

        String encodedPassword = passwordEncoder.encode(userRegister.getPassword());

        userRegister.setDatumKreiranja(LocalDate.now());


        Users user = userMapper.convertToEntityReg(userRegister);
        user.setGradRodjenja(gradRepository.findByImeGrada(userRegister.getGradRodjenja()));
        user.setKompanija(kompanijaRepository.findByImeKompanije(userRegister.getKompanija()));
        user.setAktivan(true);
        user.setPassword(encodedPassword);


        usersRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }


    @Transactional
    public void deleteByUsername(String username) throws NotFoundException {

        if (usersRepository.existsByUsername(username)){
            usersRepository.deleteByUsername(username);
        }
        else {
            FieldErrorDTO errors = new FieldErrorDTO("username", "username.not-found","User with username " + username + " does not exist");

            throw new NotFoundException("User account could not be deleted!", errors);
        }

    }

    @Transactional
    public void update(UserRegisterDTO userDTO, String username) throws NotFoundException {

        if (!usersRepository.existsByUsername(username)){
            FieldErrorDTO errors = new FieldErrorDTO("username", "username.not-found","User with username " + username + " does not exist");

            throw new NotFoundException("User account could not be updated!", errors);
        }

        Users OldUser = usersRepository.findByUsername(username);


        if(userDTO.getUsername() != null){OldUser.setUsername(userDTO.getUsername());}
        if(userDTO.getPassword() != null){OldUser.setPassword(userDTO.getPassword());}
        if(userDTO.getEmail() != null){OldUser.setEmail(userDTO.getEmail());}
        if(userDTO.getIme() != null) {OldUser.setIme(userDTO.getIme());}
        if(userDTO.getPrezime() != null){OldUser.setPrezime(userDTO.getPrezime());}
        if(userDTO.getPol() != null){OldUser.setPol(userDTO.getPol());}
        if(userDTO.getGradRodjenja() != null){ OldUser.setGradRodjenja(gradRepository.findByImeGrada(userDTO.getGradRodjenja()));}

        if(userDTO.getKompanija() != null)OldUser.setKompanija(kompanijaRepository.findByImeKompanije(userDTO.getKompanija()));


       usersRepository.save(OldUser);

    }

    public List<UsersDTO> getAllUsersByCompany(String kompanija) throws NotFoundException {
        if (kompanijaRepository.findByImeKompanije(kompanija) == null){
            FieldErrorDTO errors = new FieldErrorDTO("kompanija", "kompanija.not-found","Company with name " + kompanija + " does not exist");

            throw new NotFoundException("Could not execute search, Company not found", errors);
        }

        List<Users> users = usersRepository.getAllByCompany(kompanija);
        return userMapper.convertToListDTO(users);

    }

    public List<UsersDTO> getAllDeactiveUsers() {
        List<Users> users = usersRepository.getAllDeactive();
        return userMapper.convertToListDTO(users);
    }

    public List<UsersDTO> getAllByDate(String date) {
        List<Users> users = usersRepository.getByDateofCretion(date);
        return userMapper.convertToListDTO(users);
    }
}
