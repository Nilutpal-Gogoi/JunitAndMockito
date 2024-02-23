package com.learning.demo.junitandmockito.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class StudentScoreCalculatorTest {

    @Mock
    private StudentScoreCalculator studentScoreCalculator;

    @Before
    public void setup() {
        studentScoreCalculator = new StudentScoreCalculator();
    }

    @Test
    public void studentScoreCalculatorRegular() {
        studentScoreCalculator.calculateSATScore(50, 50);
        assertEquals(2500, studentScoreCalculator.getSatScore());
    }

    @Test
    public void studentScoreCalculatorMathsNegative() {
        studentScoreCalculator.calculateSATScore(-1, 50);
        assertEquals(-1, studentScoreCalculator.getSatScore());
    }

    @Test
    public void studentScoreCalculatorLiteracyNegative() {
        studentScoreCalculator.calculateSATScore(50, -1);
        assertEquals(-1, studentScoreCalculator.getSatScore());
    }

    @Test
    public void studentScoreCalculatorBothHigh() {
        studentScoreCalculator.calculateSATScore(150, 150);
        assertEquals(-1, studentScoreCalculator.getSatScore());
    }
}