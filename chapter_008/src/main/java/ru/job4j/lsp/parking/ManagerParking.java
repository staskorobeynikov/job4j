package ru.job4j.lsp.parking;

public class ManagerParking implements InterfaceParking {
    private final TruckParking truckParking;
    private final PassengerCarParking passengerCarParking;

    public ManagerParking(TruckParking truckParking, PassengerCarParking passengerCarParking) {
        this.truckParking = truckParking;
        this.passengerCarParking = passengerCarParking;
    }

    @Override
    public boolean start(InterfaceCar car) {
        return truckParking.start(car)
                || passengerCarParking.start(car);
    }

    @Override
    public int getCountFreeSpace() {
        return truckParking.getCountFreeSpace()
                + passengerCarParking.getCountFreeSpace();
    }
}
