package com.afs.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Console;

public class ParkingLotTest {

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
//    @Test
//    public void should_return_the_right_car_with_each_ticket_when_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
//        Car car1 = new Car(110);
//        Car car2 = new Car(120);
//
//        ParkingLot parkingLot = new ParkingLot(10);
//
//        Ticket ticket1 = parkingLot.parking(car1);
//        Ticket ticket2 = parkingLot.parking(car2);
//
//        Car fetchedCar1 = parkingLot.fetchCar(ticket1);
//        Car fetchedCar2 = parkingLot.fetchCar(ticket2);
//
//        Assertions.assertEquals(car1, fetchedCar1);
//        Assertions.assertEquals(car2, fetchedCar2);
//    }

    // Case 4 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing.
    // Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing.
    // Case 6 - Given a parking lot without any position, and a car, When park the car, Then return nothing
}
