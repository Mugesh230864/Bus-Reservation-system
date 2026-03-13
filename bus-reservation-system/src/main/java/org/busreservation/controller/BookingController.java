package org.busreservation.controller;

import org.busreservation.model.Bus;
import org.busreservation.model.Customer;
import org.busreservation.model.Booking;
import org.busreservation.service.BusService;
import org.busreservation.service.CustomerService;
import org.busreservation.service.BookingService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingController {

    private final BusService busService = new BusService();
    private final CustomerService customerService = new CustomerService();
    private final BookingService bookingService = new BookingService();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== BUS RESERVATION SYSTEM MENU ===");
            System.out.println("1. Manage Buses");
            System.out.println("2. Manage Customers");
            System.out.println("3. Book Tickets");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: busMenu(); break;
                case 2: customerMenu(); break;
                case 3: bookTicket(); break;
                case 4: viewBookings(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void busMenu() {
        while (true) {
            System.out.println("\n=== BUS MANAGEMENT ===");
            System.out.println("1. Add New Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	Bus bus = new Bus();
                	System.out.print("Enter Bus Name: ");
                	bus.setName(sc.nextLine());
                	System.out.print("Enter Source: ");
                	bus.setSource(sc.nextLine());
                	System.out.print("Enter Destination: ");
                	bus.setDestination(sc.nextLine());
                	System.out.print("Enter Total Seats: ");
                	bus.setTotalSeats(sc.nextInt());
                	sc.nextLine(); // consume leftover newline

                	busService.addBus(bus);

                case 2:
                    List<Bus> buses = busService.getAllBuses();
                    for (Bus b : buses) {
                        System.out.println("ID: " + b.getId() + ", Name: " + b.getName() +
                                ", Source: " + b.getSource() + ", Destination: " + b.getDestination());
                    }
                    break;
                case 3: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void customerMenu() {
        while (true) {
            System.out.println("\n=== CUSTOMER MANAGEMENT ===");
            System.out.println("1. Add New Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	Customer customer = new Customer();
                	System.out.print("Enter Customer Name: ");
                	customer.setName(sc.nextLine());
                	System.out.print("Enter Customer Email: ");
                	customer.setEmail(sc.nextLine());
                	System.out.print("Enter Customer Phone: ");
                	customer.setPhone(sc.nextLine()); // NEW FIELD
                	customerService.addCustomer(customer);

                    
                    break;
                case 2:
                    List<Customer> customers = customerService.getAllCustomers();
                    for (Customer c : customers) {
                        System.out.println("ID: " + c.getId() + ", Name: " + c.getName() +
                                ", Email: " + c.getEmail());
                    }
                    break;
                case 3: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void bookTicket() {
        Booking booking = new Booking();
        System.out.print("Enter Bus ID: ");
        booking.setBusId(sc.nextInt());
        System.out.print("Enter Customer ID: ");
        booking.setCustomerId(sc.nextInt());
        sc.nextLine();
        booking.setBookingDate(new Date());
        bookingService.createBooking(booking);
    }

    private void viewBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        for (Booking b : bookings) {
            System.out.println("Booking ID: " + b.getId() + ", Bus ID: " + b.getBusId() +
                    ", Customer ID: " + b.getCustomerId() + ", Date: " + b.getBookingDate());
        }
    }
}
