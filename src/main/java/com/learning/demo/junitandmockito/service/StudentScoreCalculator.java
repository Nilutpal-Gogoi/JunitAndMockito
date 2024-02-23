package com.learning.demo.junitandmockito.service;

public class StudentScoreCalculator {

    private int satScore;

    public void calculateSATScore(int mathScore , int literacyScore) {
        if(mathScore < 0 || mathScore > 100 || literacyScore < 0 || literacyScore > 100) {
            satScore = -1;
        } else {
            satScore = mathScore * literacyScore;
        }
    }

    public int getSatScore() {
        return this.satScore;
    }

}
