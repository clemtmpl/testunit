package com.example.testunitexam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GameTestUnitApplicationTests extends GameTest {
    @Mock
    private RandomGenerator randomGenerator;

    @InjectMocks
    private GameTest gameService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPlayRock() {
        when(randomGenerator.nextInt(3)).thenReturn(2); // Ordinateur joue Ciseaux
        String result = gameService.play("Pierre");
        assertEquals("Victoire", result);
    }

    @Test
    public void testPlayPaper() {
        when(randomGenerator.getClass(3)).thenReturn(0); // Ordinateur joue Pierre
        String result = gameService.play("Feuille");
        assertEquals("Victoire", result);
    }

    @Test
    public void testPlayScissors() {
        when(randomGenerator.getClass(3)).thenReturn(1); // Ordinateur joue Feuille
        String result = gameService.play("Ciseaux");
        assertEquals("Victoire", result);
    }

    @Test
    public void testPlayTie() {
        when(randomGenerator.nextInt(3)).thenReturn(0); // Ordinateur joue Pierre
        String result = gameService.play("Pierre");
        assertEquals("Égalité", result);
    }

    @Test
    public void testReset() {
        gameService.reset();
        Map<String, Integer> score = gameService.getScore();
        assertEquals(0, score.get("wins"));
        assertEquals(0, score.get("ties"));
        assertEquals(0, score.get("losses"));
    }

    @Test
    public void testGetScore() {
        Map<String, Integer> score = gameService.getScore();
        assertEquals(0, score.get("wins"));
        assertEquals(0, score.get("ties"));
        assertEquals(0, score.get("losses"));
    }

    @Test
    public void testUpdateScore() {
        gameService.updateScore(2, 1, 3);
        Map<String, Integer> score = gameService.getScore();
        assertEquals(2, score.get("wins"));
        assertEquals(3, score.get("ties"));
        assertEquals(1, score.get("losses"));
    }
}
