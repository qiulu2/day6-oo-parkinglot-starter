package com.afs.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingBoyTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    // Case 1 - Given a parking boy with a parking lot, and a car, When park the car, Then return a parking ticket.
    @Test
    public void should_return_a_parkingTicket_when_given_a_parking_boy_with_parking_lot_and_car() {
        Car car = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.park(car);

        Assertions.assertNotNull(ticket);
        Assertions.assertNotNull(ticket.getTicketNumber());
    }

    // Case 2 - Given a parking boy with a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    public void should_return_the_parked_car_when_given_a_parking_boy_with_parked_car_and_ticket() {
        Car car = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);

        Assertions.assertEquals(car, fetchedCar);
    }
}
