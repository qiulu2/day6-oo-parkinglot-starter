package com.afs.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingLotTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    // Case 1 - Given a parking lot, and a car, When park the car, Then return a parking ticket.
    @Test
    public void should_return_a_parkingTicket_when_given_a_parking_lot_and_car() {
        Car car = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parking(car);


        Assertions.assertNotNull(ticket.getTicketNumber());
        System.out.println(ticket.getTicketNumber());

    }

    // Case 2 - Given a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    public void should_return_the_parked_car_when_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() {
        Car car = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parking(car);
        Car fetchedCar = parkingLot.fetchCar(ticket);

        Assertions.assertEquals(car, fetchedCar);
    }

    //    // Case 3 - Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    @Test
    public void should_return_the_right_car_with_each_ticket_when_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        Car car1 = new Car(110);
        Car car2 = new Car(120);

        ParkingLot parkingLot = new ParkingLot(10);

        Ticket ticket1 = parkingLot.parking(car1);
        Ticket ticket2 = parkingLot.parking(car2);

        Car fetchedCar1 = parkingLot.fetchCar(ticket1);
        Car fetchedCar2 = parkingLot.fetchCar(ticket2);

        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);
    }

    // Case 4 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return null.
    @Test
    public void should_return_null_when_given_a_parking_lot_and_a_wrong_parkingTicket() {
        Car car1 = new Car(110);

        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket1 = parkingLot.parking(car1);
        Ticket wrongTicket = new Ticket(new Car(120));

        Assertions.assertNull(parkingLot.fetchCar(wrongTicket));
    }

    // Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return null.
    @Test
    public void should_return_null_when_given_a_parking_lot_and_a_used_parkingTicket() {
        Car car1 = new Car(110);

        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket1 = parkingLot.parking(car1);
        Car car =  parkingLot.fetchCar(ticket1);

        Assertions.assertNull(parkingLot.fetchCar(ticket1));
    }
    // Case 6 - Given a parking lot without any position, and a car, When park the car, Then return null
    @Test
    public void should_return_null_when_given_a_parking_lot_without_any_position_and_a_car() {
        Car car1 = new Car(110);

        ParkingLot parkingLot = new ParkingLot(0);
        Ticket ticket1 = parkingLot.parking(car1);

        Assertions.assertNull(ticket1);
    }

    // case 7 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return error msg "Unrecognized parking ticket"
    @Test
    public void should_return_msg_unrecognized_when_given_a_parking_lot_and_a_wrong_parking_ticket(){
        Car car1 = new Car(110);
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket1 = parkingLot.parking(car1);
        Ticket wrongTicket = new Ticket(new Car(120));
        Car fetchedCar1 = parkingLot.fetchCar(wrongTicket);


        Assertions.assertEquals("Unrecognized parking ticket", outputStream.toString().trim());

    }

    // case 8 - Given a parking lot without any position, and a car, When park the car, Then return error msg "No available position"
    @Test
    public void should_return_no_available_msg_when_given_a_parking_lot_without_any_position_and_a_car(){
        Car car1 = new Car(110);
        ParkingLot parkingLot = new ParkingLot(0);
        Ticket ticket1 = parkingLot.parking(car1);

        Assertions.assertEquals("No available position",outputStream.toString().trim());
    }
}
