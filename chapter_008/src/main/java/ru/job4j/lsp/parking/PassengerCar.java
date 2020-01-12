package ru.job4j.lsp.parking;

public class PassengerCar implements InterfaceCar {
    private final int size;

    public PassengerCar(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
