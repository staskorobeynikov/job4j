package ru.job4j.poly;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " летит по воздуху.");
    }

    @Override
    public void getFuel() {
        System.out.println(getClass().getSimpleName()
                + " необходимо заправить керосином.");
    }
}
