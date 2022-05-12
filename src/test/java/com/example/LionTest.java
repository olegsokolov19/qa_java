package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private final String sex;
    private Lion lion;

    boolean expectedHasManeResult;
    String expectedError = "Используйте допустимые значения пола животного - Самец или Самка";

    public LionTest(String sex, boolean expectedHasManeResult) {
        this.sex = sex;
        this.expectedHasManeResult = expectedHasManeResult;
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getHasMane() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() throws Exception {
        lion = new Lion(sex, feline);
    }

    @Test
    public void shouldReturnOneKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);

        int expected = 1;
        int actual = lion.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveManeTrue() {
        boolean actual = lion.doesHaveMane();

        assertEquals(expectedHasManeResult, actual);
    }

    @Test
    public void shouldThrowExceptionWithIncorrectMane() {
        String actual = Assert.assertThrows(Exception.class, () -> new Lion("Другое", feline)).getMessage();

        assertEquals(expectedError, actual);
    }

    @Test
    public void shouldReturnPredator() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
    }
}