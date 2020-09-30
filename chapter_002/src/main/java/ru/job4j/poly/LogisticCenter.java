package ru.job4j.poly;

public class LogisticCenter {
    public static void main(String[] args) {
        Vehicle aircraft = new Aircraft();
        Vehicle train = new Train();
        Vehicle bus = new PassengerBus();

        Vehicle[] vehicles = new Vehicle[]{aircraft, train, bus};

        for (Vehicle v : vehicles) {
            v.move();
            v.getFuel();
            System.out.println();
        }
    }
}
