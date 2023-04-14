package com.example.democarcrud.Services;

import com.example.democarcrud.Entities.User;
import com.example.democarcrud.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> ReadUsers() {
        return (List<User>) userRepository.findAll();
    }




    @Override
    public HttpStatus deleteUser(Long aLong) {
        userRepository.deleteById(aLong);
        return HttpStatus.OK;
    }




    @Override
    public HttpStatus UpdateUser(User user, Long id) {
        return userRepository.findById(id).map(c->{
            c.setCin(user.getCin());
            c.setFirstName(user.getFirstName());
            c.setLastName(user.getLastName());
            c.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(c);
            return HttpStatus.OK;
        }).orElseThrow(()->new RuntimeException("Not found"));
    }
}
