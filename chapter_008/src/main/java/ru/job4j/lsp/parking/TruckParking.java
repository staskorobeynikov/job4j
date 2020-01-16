package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class TruckParking implements InterfaceParking {
    private int parkingSize;
    private List<InterfaceCar> truckList = new ArrayList<>();

    public TruckParking(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    @Override
    public boolean start(InterfaceCar car) {
        boolean result = false;
        if (car instanceof Truck && getCountFreeSpace() > 0) {
            truckList.add(car);
            result = true;
        }
        return result;
    }

    @Override
    public int getCountFreeSpace() {
        return parkingSize - truckList.size();
    }
}
