package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ManagerParkingTest {

    @Test
    public void whenAddPassengerCarStartIsTrue() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(3),
                new PassengerCarParking(2)
        );
        InterfaceCar car = new PassengerCar(1);

        boolean result = managerParking.start(car);

        assertTrue(result);
    }

    @Test
    public void whenAddPassengerCarGetCountFreeSpaceIsNotNull() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(0),
                new PassengerCarParking(2)
        );
        InterfaceCar car = new PassengerCar(1);
        managerParking.start(car);

        int result = managerParking.getCountFreeSpace();

        assertThat(result, is(1));
    }

    @Test
    public void whenAddTwoPassengerCarsStartIsFalse() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(3),
                new PassengerCarParking(1)
        );
        managerParking.start(new PassengerCar(1));
        InterfaceCar car = new PassengerCar(1);
        boolean result = managerParking.start(car);

        assertFalse(result);
    }

    @Test
    public void whenAddTwoPassengerCarsGetCountFreeSpaceIsNull() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(0),
                new PassengerCarParking(2)
        );
        managerParking.start(new PassengerCar(1));
        managerParking.start(new PassengerCar(1));

        int result = managerParking.getCountFreeSpace();

        assertThat(result, is(0));
    }

    @Test
    public void whenAddTruckStartIsTrue() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(3),
                new PassengerCarParking(2)
        );
        InterfaceCar truck = new Truck(2);

        boolean result = managerParking.start(truck);

        assertTrue(result);
    }

    @Test
    public void whenAddTruckGetCountFreeSpaceThenNotNull() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(2),
                new PassengerCarParking(0)
        );
        InterfaceCar truck = new Truck(2);
        managerParking.start(truck);

        int result = managerParking.getCountFreeSpace();

        assertThat(result, is(1));
    }

    @Test
    public void whenAddTwoTrucksStartIsFalse() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(1),
                new PassengerCarParking(0)
        );
        managerParking.start(new Truck(2));
        Truck truck = new Truck(2);
        boolean result = managerParking.start(truck);

        assertFalse(result);
    }

    @Test
    public void whenAddTwoTrucksGetCountFreeSpaceIsNull() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(2),
                new PassengerCarParking(0)
        );
        managerParking.start(new Truck(2));
        managerParking.start(new Truck(2));

        int result = managerParking.getCountFreeSpace();

        assertThat(result, is(0));
    }

    @Test
    public void whenAddPassengerCarAndTruckStartIsTrue() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(3),
                new PassengerCarParking(2)
        );
        managerParking.start(new PassengerCar(1));
        InterfaceCar car = new Truck(2);

        boolean result = managerParking.start(car);

        assertTrue(result);
    }

    @Test
    public void whenAddPassengerCarAndTruckStartIsFalse() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(0),
                new PassengerCarParking(2)
        );
        managerParking.start(new PassengerCar(1));
        InterfaceCar car = new Truck(2);

        boolean result = managerParking.start(car);

        assertFalse(result);
    }

    @Test
    public void whenAddPassengerCarAndTruckGetCountFreeSpaceIsNotNull() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(1),
                new PassengerCarParking(2)
        );
        managerParking.start(new PassengerCar(1));
        managerParking.start(new Truck(2));

        int result = managerParking.getCountFreeSpace();

        assertThat(result, is(1));
    }

    @Test
    public void whenAddPassengerCarAndTruckGetCountFreeSpaceIsNull() {
        ManagerParking managerParking = new ManagerParking(
                new TruckParking(1),
                new PassengerCarParking(1)
        );
        managerParking.start(new PassengerCar(1));
        managerParking.start(new Truck(2));

        int result = managerParking.getCountFreeSpace();

        assertThat(result, is(0));
    }
}