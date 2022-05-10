package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodShouldReturnListForHerbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodWithIncorrectAnimalShouldThrowException() {
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = assertThrows(Exception.class, () -> animal.getFood("Рыба")).getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();

        assertEquals(expected, actual);
    }
}