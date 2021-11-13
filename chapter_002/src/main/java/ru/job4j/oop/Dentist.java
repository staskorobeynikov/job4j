package ru.job4j.oop;

public class Dentist extends Doctor {
    public Dentist(String n, String sn, String e, String y, String sp) {
        super(n, sn, e, y, sp);
    }

    public void pullTooth() {
        System.out.println("pullTooth");
    }

    public void putSeal() {
        System.out.println("putSeal");
    }
}
