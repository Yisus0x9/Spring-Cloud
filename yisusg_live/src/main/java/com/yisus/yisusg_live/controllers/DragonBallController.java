package com.yisus.yisusg_live.controllers;

import com.github.javafaker.Faker;
import com.yisus.yisusg_live.services.FooService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dragonball/characters")
public class DragonBallController {

    private static final Logger log = LoggerFactory.getLogger(DragonBallController.class);

    @Autowired
    private Faker faker;
    @Autowired
    private FooService service;

    private List<String> characters= new ArrayList<>();


    @PostConstruct
    public void init(){
        for (int i = 0; i < 30; i++) {
            characters.add(faker.dragonBall().character());
        }
    }

    @GetMapping
    public ResponseEntity<List<String>> get(){
        log.info("Getting characters db");
        service.printLogs();
        return ResponseEntity.ok(characters);
    }
}
