package com.example.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {

    private static final Logger logger = LoggerFactory.getLogger(HomeControler.class);

    @GetMapping("/")
    public String home(){
        logger.info("Home endpoint accessed");
        return "welcome to your Spring Boot App ! ";
    }
}