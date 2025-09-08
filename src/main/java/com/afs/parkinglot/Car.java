package com.afs.parkinglot;

public class Car {
    private Integer carNumber;

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public Car(Integer carNumber) {
        this.carNumber = carNumber;
    }
}
