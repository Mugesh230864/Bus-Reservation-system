package org.busreservation.model;

public class Bus {
    private int id;
    private String name;        // corresponds to bus_name in DB
    private String source;
    private String destination;
    private int totalSeats;     // NEW FIELD

    // Default constructor
    public Bus() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public int getTotalSeats() { return totalSeats; }      // NEW GETTER
    public void setTotalSeats(int totalSeats) {            // NEW SETTER
        this.totalSeats = totalSeats;
    }
}
