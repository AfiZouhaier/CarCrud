package com.example.democarcrud.auth;

import com.example.democarcrud.Entities.User;
import com.example.democarcrud.Respository.UserRepository;
import com.example.democarcrud.configurations.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        System.out.println(registerRequest);
        User user = new User();
        user.setCin(registerRequest.getCin());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setUserRole(registerRequest.getRole());
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByEmail(authenticationRequest.getEmail());


    try {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
            )
    );
    System.out.println("authentication done");
    }catch (AuthenticationException err){
    System.out.println(err);
    return AuthenticationResponse.builder().token("Bad credentials").build();
    }
    Map<String, Object> userToSend = new HashMap<>();
    userToSend.put("userDetails", user);    
        var jwtToken = jwtService.generateToken(userToSend, user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
