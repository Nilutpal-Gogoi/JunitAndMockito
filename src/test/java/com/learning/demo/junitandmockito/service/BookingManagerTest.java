package com.learning.demo.junitandmockito.service;

import com.learning.demo.junitandmockito.dao.HotelDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {

    private HotelDao hotelDaoMock;
    private BookingManager bookingManager;

    @Before
    public void setup() throws SQLException {
        hotelDaoMock = mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDaoMock);

        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);
    }

    @Test
    public void checkAvailabilityRoomsTrue() throws SQLException {
        assertTrue(bookingManager.checkRoomsAvailability("A"));
    }

    @Test
    public void checkAvailabilityRoomsFalse() throws SQLException {
        assertFalse(bookingManager.checkRoomsAvailability("B"));
    }
}