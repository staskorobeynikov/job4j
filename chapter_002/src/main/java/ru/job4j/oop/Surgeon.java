package ru.job4j.oop;

public class Surgeon extends  Doctor {
    public Surgeon(String n, String sn, String e, String y, String sp) {
        super(n, sn, e, y, sp);
    }

    public void doSurgery() {
        System.out.println("doSurgery");
    }

    public void makeIncision() {
        System.out.println("makeIncision");
    }
}
