package com.example.springwebdemo100;

import com.example.springwebdemo100.entity.Hero;
import com.example.springwebdemo100.repository.HeroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SpringWebDemo100ApplicationTests extends AbstractTest {

    @Autowired
    private HeroRepository heroRepository;

    @Test
    void contextLoads() {
        System.out.println("Context loaded!!");
    }

    @Test
    void saveBoot() {
        Hero hero1 = Hero.builder().id(1).name("name1").build();
        Hero saveHero = heroRepository.save(hero1);
        Hero findByIdHero = heroRepository.findById(1).orElse(Hero.builder().build());

        Assertions.assertEquals(hero1.getId(), saveHero.getId());
        Assertions.assertEquals(hero1.getName(), saveHero.getName());

        Assertions.assertEquals(hero1.getName(), findByIdHero.getName());
    }

}
