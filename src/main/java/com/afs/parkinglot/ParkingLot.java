package com.afs.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private Integer capacity;
    private List<Ticket> tickets;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (capacity <= 0) {
            return null;
        }
        capacity--;
        Ticket ticket = new Ticket(car);
        tickets.add(ticket);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        return null;
    }
}
