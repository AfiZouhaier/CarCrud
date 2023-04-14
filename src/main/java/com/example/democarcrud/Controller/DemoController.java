package com.example.democarcrud.Controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.aspectj.bridge.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.OPTIONS}, path = "get", headers = "Authorization")
    public ResponseEntity<String> g(){

    return ResponseEntity.ok("Hello from a secure End point");
    }
}
