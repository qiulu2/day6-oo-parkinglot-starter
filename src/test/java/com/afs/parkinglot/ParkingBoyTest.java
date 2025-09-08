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

    // Story 3 - Case 1 - Given a parking boy with a parking lot, and a car, When park the car, Then return a parking ticket.
    @Test
    public void should_return_a_parkingTicket_when_given_a_parking_boy_with_parking_lot_and_car() {
        Car car = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.park(car);

        Assertions.assertNotNull(ticket);
        Assertions.assertNotNull(ticket.getTicketNumber());
    }

    // Story 3 - Case 2 - Given a parking boy with a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    public void should_return_the_parked_car_when_given_a_parking_boy_with_parked_car_and_ticket() {
        Car car = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);

        Assertions.assertEquals(car, fetchedCar);
    }

    // Story 4 - Case 1: Given a parking boy with two parking lots (capacity 1 each), when park 2 cars, then cars should be parked in first lot then second lot
    @Test
    public void should_park_cars_in_first_lot_then_second_lot_when_given_parking_boy_with_two_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);

        Car car1 = new Car(111);
        Car car2 = new Car(222);

        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);

        Assertions.assertNotNull(ticket1);
        Assertions.assertNotNull(ticket2);

        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);

        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);
    }

    // Story 4 - Case 2: Given a parking boy with two full parking lots, when park a car, then return null
    @Test
    public void should_return_null_when_all_parking_lots_are_full() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);

        Car car1 = new Car(111);
        Car car2 = new Car(222);
        Car car3 = new Car(333);

        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        // This should fail
        Ticket ticket3 = parkingBoy.park(car3);

        Assertions.assertNotNull(ticket1);
        Assertions.assertNotNull(ticket2);
        Assertions.assertNull(ticket3);
        Assertions.assertEquals("No available position", outputStream.toString().trim());
    }

    // Story 4 - Case 3: Given a parking boy with multiple parking lots, when fetch car with wrong ticket, then return null
    @Test
    public void should_return_null_when_fetch_with_wrong_ticket_from_multiple_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);

        Car car1 = new Car(111);
        Ticket wrongTicket = new Ticket(new Car(999));

        parkingBoy.park(car1);
        Car fetchedCar = parkingBoy.fetch(wrongTicket);

        Assertions.assertNull(fetchedCar);
        Assertions.assertEquals("Unrecognized parking ticket", outputStream.toString().trim());
    }
}
