package org.busreservation.dao;

import org.busreservation.model.Booking;
import org.busreservation.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public void addBooking(Booking booking) {
        String sql = "INSERT INTO booking (bus_id, customer_id, booking_date) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, booking.getBusId());
            ps.setInt(2, booking.getCustomerId());
            ps.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            ps.executeUpdate();
            System.out.println("Booking added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding booking: " + e.getMessage());
        }
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM booking";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setBusId(rs.getInt("bus_id"));
                booking.setCustomerId(rs.getInt("customer_id"));
                booking.setBookingDate(rs.getDate("booking_date"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving bookings: " + e.getMessage());
        }
        return bookings;
    }
}
