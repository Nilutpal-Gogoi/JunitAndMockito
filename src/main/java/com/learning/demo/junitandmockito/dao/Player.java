package com.learning.demo.junitandmockito.dao;

import lombok.Data;

import static jdk.dynalink.linker.support.Guards.isNotNull;

@Data
public class Player {

    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Player p = (Player) obj;
        return p.getName() == this.getName();
    }

}
