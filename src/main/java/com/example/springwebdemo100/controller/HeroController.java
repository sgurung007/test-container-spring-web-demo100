package com.example.springwebdemo100.controller;

import com.example.springwebdemo100.entity.Hero;
import com.example.springwebdemo100.service.HeroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @PostMapping("/save-hero")
    @ResponseStatus(HttpStatus.CREATED)
    public Hero saveHero(@RequestBody Hero hero){
        Hero saveHero = heroService.saveHero(hero);
        log.info("returning hero: {}",saveHero);
        return saveHero;
    }

    @GetMapping("/get-all-hero")
    @ResponseStatus(HttpStatus.OK)
    public List<Hero> getAllHero(){
        List<Hero> allHero = heroService.getAllHero();
        log.info("returning all hero: {}",allHero);
        return allHero;
    }
}
