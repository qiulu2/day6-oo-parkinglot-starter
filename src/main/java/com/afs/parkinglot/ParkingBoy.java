package com.afs.parkinglot;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            Ticket ticket = parkingLot.tryPark(car);
            if (ticket != null) {
                return ticket;
            }
        }
        System.out.println("No available position");
        return null;
    }

    public Car fetch(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.tryFetch(ticket);
            if (car != null) {
                return car;
            }
        }
        System.out.println("Unrecognized parking ticket");
        return null;
    }
}
