package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class PassengerCarParking implements InterfaceParking {
    private int parkingSize;
    private List<InterfaceCar> passengerCarList = new ArrayList<>();

    public PassengerCarParking(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    @Override
    public boolean start(InterfaceCar car) {
        boolean result = false;
        if (car instanceof PassengerCar && getCountFreeSpace() > 0) {
            passengerCarList.add(car);
            result = true;
        } else if (car.getSize() < parkingSize) {
            parkingSize -= car.getSize();
            result = true;
        }
        return result;
    }

    @Override
    public int getCountFreeSpace() {
        return parkingSize - passengerCarList.size();
    }
}
