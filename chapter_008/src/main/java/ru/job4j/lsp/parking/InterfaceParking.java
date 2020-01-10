package ru.job4j.lsp.parking;

public interface InterfaceParking {
    /**
     * Method determines possibility to park.
     *
     * @param car object car.
     * @return true - car parked.
     */
    boolean start(InterfaceCar car);
}
