package org.busreservation.service;

import org.busreservation.dao.BookingDAO;
import org.busreservation.model.Booking;

import java.util.List;

public class BookingService {
    private BookingDAO bookingDAO = new BookingDAO();

    public void createBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }
}
