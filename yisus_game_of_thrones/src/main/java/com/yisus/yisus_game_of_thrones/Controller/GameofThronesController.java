package com.yisus.yisus_game_of_thrones.Controller;

import com.github.javafaker.Faker;
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
@RequestMapping("/api/v1/gameofthrones/characters")
public class GameofThronesController {

    @Autowired
    private Faker faker;
    private static final Logger log = LoggerFactory.getLogger(GameofThronesController.class);

    private List<String> characters= new ArrayList<>();


    @PostConstruct
    public void init(){
        for (int i = 0; i < 30; i++) {
            characters.add(faker.gameOfThrones().character());
        }
    }

    @GetMapping
    public ResponseEntity<List<String>> get(){
        log.info("Getting characters GT");
        return ResponseEntity.ok(characters);
    }
}