package ru.job4j.poly;

public class PassengerBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " движется по скоростной трассе.");
    }

    @Override
    public void getFuel() {
        System.out.println(getClass().getSimpleName()
                + " необходимо заправить бензином.");
    }
}
