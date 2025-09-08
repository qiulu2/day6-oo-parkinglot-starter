package com.afs.parkinglot;

import java.util.UUID;

public class Ticket {
    private Integer ticketNumber;
    private Car car;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


    public Ticket(Car car) {
        this.car = car;
        this.ticketNumber = UUID.randomUUID().hashCode();
    }
}
