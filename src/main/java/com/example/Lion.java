package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final int kittens = 1;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() {
        return kittens;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        Animal animal = new Animal();
        return animal.getFood("Хищник");
    }

}