package com.example;

import java.util.List;

public class Alex extends Lion {

    private final List<String> friends = List.of("Марти", "Глория", "Мелман");
    private final String location = "Нью-Йоркский зоопарк";

    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    @Override
    public boolean doesHaveMane() {
        return true;
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getPlaceOfLiving() {
        return location;
    }
}
