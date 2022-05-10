package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void initialize() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();

        assertEquals(expected, actual);
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();

        assertEquals(expected, actual);
    }

    @Test
    public void getKittens() {
        int expected = 1;
        int actual = feline.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithParameters() {
        int kittensCount = 7;
        int actual = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actual);
    }
}