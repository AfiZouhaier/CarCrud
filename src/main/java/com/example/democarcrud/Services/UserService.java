package com.example.democarcrud.Services;

import com.example.democarcrud.Entities.User;
import com.example.democarcrud.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {


    User CreateUser(User user);
    List<User> ReadUsers();

    HttpStatus UpdateUser(User user, Long id);
    HttpStatus deleteUser(Long id);



}
