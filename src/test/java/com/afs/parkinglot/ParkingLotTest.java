package com.afs.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    // Case 1 - Given a parking lot, and a car, When park the car, Then return a parking ticket.
    public void should_return_a_parkingTicket_when_given_a_parking_lot_and_car() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parking(car);


        Assertions.assertNotNull(ticket);
    }

    // Case 2 - Given a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    // Case 3 - Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    // Case 4 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing.
    // Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing.
    // Case 6 - Given a parking lot without any position, and a car, When park the car, Then return nothing
}
