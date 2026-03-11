package com.example.revconnect.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @GetMapping("/test")
    public String test() {

        logger.info("INFO log - API called");
        logger.warn("WARN log - sample warning");
        logger.error("ERROR log - sample error");

        return "Log4j working";
    }
}