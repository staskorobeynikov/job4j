package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int capacity) {
        this.load = capacity;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }
    public static void main() {
        Battery first = new Battery(30);
        Battery second = new Battery(20);
        System.out.println("first : " + first.load + ". second : " + second.load);
        second.exchange(first);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }
}
