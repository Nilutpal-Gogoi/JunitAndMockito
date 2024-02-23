package com.learning.demo.junitandmockito.service;

import com.learning.demo.junitandmockito.dao.Player;
import lombok.Data;

@Data
public class PlayerStatistics {

    private Player player;
    private int games;
    private int goals;

    public PlayerStatistics(Player player, int games, int goals) {
        this.player = player;
        this.games = games;
        this.goals = goals;
    }

    public double gamesPerGoal() {
        return (double)this.games / (double)this.goals;
    }

    public double goalsPerGame() {
        return (double) this.goals / (double) this.games;
    }

    public boolean underThirty() {
        return this.player.getAge() < 30;
    }

    public Double[] createCsvRecord() {
        if(this.games == 0) {
            return null;
        } else {
            return new Double[]{goalsPerGame(), gamesPerGoal()};
        }
    }

    public static Player getYoungerPlayer(Player player1, Player player2) {
        if(player2.getAge() < player1.getAge()) {
            System.out.println("youngest: "+ player2.getName() + "->" + player2.getAge());
            return player2;
        } else {
            System.out.println("youngest: "+ player2.getName() + "->" + player2.getAge());
            return player1;
        }
    }

}
