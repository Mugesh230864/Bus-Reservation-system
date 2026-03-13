package org.busreservation.service;

import org.busreservation.dao.BusDAO;
import org.busreservation.model.Bus;

import java.util.List;

public class BusService {
    private BusDAO busDAO = new BusDAO();

    public void addBus(Bus bus) {
        busDAO.addBus(bus);
    }

    public List<Bus> getAllBuses() {
        return busDAO.getAllBuses();
    }
}
