package com.example.testunitexam;

import java.util.HashMap;
import java.util.Map;
public class GameTest {

    private int wins;
    private int ties;
    private int losses;

    public String play(String action) {
        String computerAction = getAction();
        if (action.equals(computerAction)) {
            ties++;
            return "Égalité";
        } else if (action.equals("Pierre") && computerAction.equals("Ciseaux")
                || action.equals("Feuille") && computerAction.equals("Pierre")
                || action.equals("Ciseaux") && computerAction.equals("Feuille")) {
            wins++;
            return "Victoire";
        } else {
            losses++;
            return "Défaite";
        }
    }

    private String getAction() {
        String[] actions = {"Pierre", "Feuille", "Ciseaux"};
        int index = (int) (Math.random() * 3);
        return actions[index];
    }

    public void reset() {
        wins = 0;
        ties = 0;
        losses = 0;
    }

    public Map<String, Integer> getScore() {
        Map<String, Integer> score = new HashMap<>();
        score.put("wins", wins);
        score.put("ties", ties);
        score.put("losses", losses);
        return score;
    }

    public void updateScore(int win, int loss, int tie) {
        wins += win;
        losses += loss;
        ties += tie;

    }

    public String getLastComputerAction() {
        return lastComputerAction;
    }

    public void setLastComputerAction(String lastComputerAction) {
        this.lastComputerAction = lastComputerAction;
    }
}
