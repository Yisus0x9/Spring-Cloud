package com.yisus.yisusg_live.controllers;

import com.yisus.yisusg_live.config.Yisus09Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-name")
public class ApplicationNameController {

    @Autowired
    private Yisus09Config config;

    private static final Logger log = LoggerFactory.getLogger(ApplicationNameController.class);

    @GetMapping
    public ResponseEntity<String> getAppName(){
        log.info("Gettting application name");
        return new ResponseEntity<>(config.getName(),HttpStatus.OK);
    }
}
