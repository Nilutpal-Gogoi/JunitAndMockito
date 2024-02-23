package com.learning.demo.junitandmockito.service;

import com.learning.demo.junitandmockito.dao.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerStatisticsTest {

    @Test
    public void playerNameEqual() {
        Player player1 = new Player("Patrick", 27);
        Player player2 = new Player("Patrick", 25);
        assertEquals(player1, player2);
    }

    @Test
    public void playerNameNotEqual() {
        Player player1 = new Player("Patrick", 27);
        Player player2 = new Player("Kevin", 25);
        assertNotEquals(player1, player2);
    }

    @Test
    public void youngerPlayerSame() {
        Player player1 = new Player("Patrick", 27);
        Player player2 = new Player("Patrick", 25);
        assertSame(player2, PlayerStatistics.getYoungerPlayer(player1, player2));
    }

    @Test
    public void underThirtyTrue() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        assertTrue(statistics.underThirty());
    }

    @Test
    public void underThirtyFalse() {
        Player player1 = new Player("Patrick", 37);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        assertFalse(statistics.underThirty());
        assertEquals(false, statistics.underThirty());
    }

    @Test
    public void csvReportNull() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics statistics = new PlayerStatistics(player1, 0, 0);
        assertNull(statistics.createCsvRecord());
    }

    @Test
    public void csvReportNotNull() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        assertNotNull(statistics.createCsvRecord());
    }

    @Test
    public void getCsvStatsRecord() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics statistics = new PlayerStatistics(player1, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        assertArrayEquals(expectedArray, statistics.createCsvRecord());
    }
}