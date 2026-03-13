package org.busreservation;

import org.busreservation.controller.BookingController;

public class App {
    public static void main(String[] args) {
        BookingController controller = new BookingController();
        controller.start();
    }
}
