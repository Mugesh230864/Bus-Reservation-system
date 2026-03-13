package org.busreservation.dao;

import org.busreservation.model.Bus;
import org.busreservation.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    // Add a new bus
    public void addBus(Bus bus) {
    	String sql = "INSERT INTO bus (bus_name, source, destination, total_seats) VALUES (?, ?, ?, ?)";

    	try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

    		ps.setString(1, bus.getName());
    		ps.setString(2, bus.getSource());
    		ps.setString(3, bus.getDestination());
    		ps.setInt(4, bus.getTotalSeats()); // <-- this was missing

            ps.executeUpdate();
            System.out.println("Bus added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding bus: " + e.getMessage());
        }
    }

    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM bus";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("bus_id"));             // updated column name
                bus.setName(rs.getString("bus_name"));      // updated column name
                bus.setSource(rs.getString("source"));
                bus.setDestination(rs.getString("destination"));
                bus.setTotalSeats(rs.getInt("total_seats")); // new field
                buses.add(bus);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving buses: " + e.getMessage());
        }

        return buses;
    }

}
