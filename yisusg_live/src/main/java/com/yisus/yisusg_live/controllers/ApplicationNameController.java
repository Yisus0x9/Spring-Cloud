package com.yisus.yisusg_live.controllers;

import com.yisus.yisusg_live.config.Yisus09Config;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/application-name")
public class ApplicationNameController {

    @Autowired
    private Yisus09Config config;

    @Autowired
    private MeterRegistry meterRegistry;
    private static final Logger log = LoggerFactory.getLogger(ApplicationNameController.class);

    @GetMapping
    @Timed("yisusg.live.name")
    public ResponseEntity<String> getAppName(){
        int value= new Random().nextInt(5);
        meterRegistry.counter("yisusg_live","level",(value<2)?"menor":"mayor").increment(value);
        log.info("Gettting application name");
        return new ResponseEntity<>(config.getName(),HttpStatus.OK);
    }
}
