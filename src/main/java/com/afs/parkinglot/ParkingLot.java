package com.afs.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private Integer capacity;
    private final List<Ticket> tickets;
//    private List<Ticket> usedTickets;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (capacity <= 0) {
            System.out.println("No available position");
            return null;
        }
        capacity--;
        Ticket ticket = new Ticket(car);
        tickets.add(ticket);
        return ticket;
    }

    public Ticket tryPark(Car car) {
        if (capacity <= 0) {
            return null;
        }
        capacity--;
        Ticket ticket = new Ticket(car);
        tickets.add(ticket);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        for (Ticket t : tickets) {
            if (t.getTicketNumber().equals(ticket.getTicketNumber())) {
                Car car = t.getCar();
                tickets.remove(t);
                capacity++;
                return car;
            }
        }
        System.out.println("Unrecognized parking ticket");
        return null;
    }

    public Car tryFetch(Ticket ticket) {
        for (Ticket t : tickets) {
            if (t.getTicketNumber().equals(ticket.getTicketNumber())) {
                Car car = t.getCar();
                tickets.remove(t);
                capacity++;
                return car;
            }
        }
        return null;
    }
}
