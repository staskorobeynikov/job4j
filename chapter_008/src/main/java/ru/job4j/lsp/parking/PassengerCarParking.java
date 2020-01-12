package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class PassengerCarParking implements InterfaceParking {
    private final int parkingSize;
    private List<PassengerCar> passengerCarList = new ArrayList<>();

    public PassengerCarParking(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    @Override
    public boolean start(InterfaceCar car) {
        return false;
    }

    @Override
    public int getCountFreeSpace() {
        return 0;
    }
}
