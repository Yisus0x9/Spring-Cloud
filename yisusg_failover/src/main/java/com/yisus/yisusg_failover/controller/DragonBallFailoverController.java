package com.yisus.yisusg_failover.controller;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dragonball/characters")
public class DragonBallFailoverController {

    @Autowired
    private Faker faker;

    private List<String> characters= new ArrayList<>();


    @PostConstruct
    public void init(){
        for (int i = 0; i < 30; i++) {
            characters.add(String.format("failover - %s",faker.dragonBall().character()));
        }
    }

    @GetMapping
    public ResponseEntity<List<String>> get(){
        return ResponseEntity.ok(characters);
    }
}