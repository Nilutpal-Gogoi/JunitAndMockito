package com.learning.demo.junitandmockito.service;

import com.learning.demo.junitandmockito.dao.HotelDao;

import java.sql.SQLException;
import java.util.List;

public class BookingManager {

    private HotelDao dao;

    public BookingManager(HotelDao dao) {
        this.dao = dao;
    }

    public boolean checkRoomsAvailability(String roomName) throws SQLException {
        List<String> availableRooms = dao.fetchAvailableRooms();
        return availableRooms.contains(roomName);
    }
}
