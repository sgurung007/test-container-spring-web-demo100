package com.example.springwebdemo100.repository;

import com.example.springwebdemo100.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
}
