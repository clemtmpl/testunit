package com.example.testunitexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameTest gameService;

    @GetMapping("/play/{action}")
    public String play(@PathVariable String action) {
        String result = gameService.play(action);
        String computerAction = gameService.getLastComputerAction();
        return String.format("Vous avez joué %s, l'ordinateur a joué %s, vous avez %s", action, computerAction, result);
    }

    @PostMapping("/restart")
    public void restart() {
        gameService.reset();
    }

    @GetMapping("/score")
    public Map<String, Integer> getScore() {
        return gameService.getScore();
    }

    @PutMapping("/score/{win}/{lose}/{tie}")
    public void updateScore(@PathVariable int win, @PathVariable int lose, @PathVariable int tie) {
        gameService.updateScore(win, lose, tie);
    }
}