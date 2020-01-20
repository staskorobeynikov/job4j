package ru.job4j.poly;


public class Bus implements Transport {
    @Override
    public void drive() {
        int amountFuel = 10;
        if (amountFuel > 0) {
                System.out.println("Автобус может ехать");
        }
    }

    @Override
    public void amountPassengers(int amount) {
        System.out.println("В автобусе есть: " + amount + " пассажиров");
    }

    @Override
    public int fillCar(int amountFuel) {
        int cost = amountFuel * 44;
        return cost;
    }
    public static void main() {
        Bus bus = new Bus();
        bus.drive();
        bus.amountPassengers(10);
        int result = bus.fillCar(50);
        System.out.println("Для заправки автобуса необходимо " + result + " рублей");
    }
}

