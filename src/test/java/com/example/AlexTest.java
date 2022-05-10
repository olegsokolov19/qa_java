package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Lion lion;

    Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(lion);
    }

    @Test
    public void getKittens() {
        int expected = 0;
        int actual = alex.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() {
        boolean expected = true;
        boolean actual = alex.doesHaveMane();

        assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = alex.getFood();

        assertEquals(expected, actual);
    }

    @Test
    public void getFriends() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        List<String> actual = alex.getFriends();

        assertEquals(expected, actual);
    }

    @Test
    public void getPlaceOfLiving() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();

        assertEquals(expected, actual);
    }
}