package com.example.democarcrud.auth;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @RequestMapping(path="register", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        System.out.println(registerRequest);
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="authenticate", method = {RequestMethod.GET,RequestMethod.OPTIONS, RequestMethod.POST})
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println("controller");
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
