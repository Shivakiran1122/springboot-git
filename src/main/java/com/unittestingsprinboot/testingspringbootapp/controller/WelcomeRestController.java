package com.unittestingsprinboot.testingspringbootapp.controller;

import com.unittestingsprinboot.testingspringbootapp.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
    @Autowired
     private WelcomeService welcomeService;
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMsg()
    {
        String welcomeMsg= welcomeService.getWelcomeMessage();
         return  new ResponseEntity<String>(welcomeMsg, HttpStatus.OK);
    }
}
