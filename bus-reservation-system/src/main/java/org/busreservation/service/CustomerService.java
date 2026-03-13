package org.busreservation.service;

import org.busreservation.dao.CustomerDAO;
import org.busreservation.model.Customer;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAO(); // final is good practice

    // Add a new customer
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
