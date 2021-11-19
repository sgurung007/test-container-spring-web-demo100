package com.example.springwebdemo100.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Entity
public class Hero {
    @Id
    private int id;

    private String name;

}
