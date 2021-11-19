package com.example.springwebdemo100.service;

import com.example.springwebdemo100.entity.Hero;
import com.example.springwebdemo100.repository.HeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Transactional
    public Hero saveHero(Hero hero){
        Hero saveHero = heroRepository.save(hero);
        log.info("saving: {}",saveHero);
        return saveHero;
    }

    public List<Hero> getAllHero(){
        List<Hero> allHero = heroRepository.findAll();
        log.info("returning all hero: {}",allHero);
        return allHero;
    }

    public Hero getHeroById(int id){
        Hero heroById = heroRepository.findById(id).orElse(Hero.builder().build());
        log.info("returning heroById: {}",heroById);
        return heroById;
    }

}
