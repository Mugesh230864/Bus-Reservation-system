package org.busreservation.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone; // NEW FIELD

    // Default constructor
    public Customer() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }       // NEW GETTER
    public void setPhone(String phone) {             // NEW SETTER
        this.phone = phone;
    }
}
