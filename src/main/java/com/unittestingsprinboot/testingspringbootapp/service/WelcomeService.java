package com.unittestingsprinboot.testingspringbootapp.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public   String getWelcomeMessage()
    {
        return  " welcome to java";
    }
}
