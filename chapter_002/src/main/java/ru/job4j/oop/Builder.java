package ru.job4j.oop;

public class Builder extends Engineer {
    public Builder(String n, String sn, String e, String y, String cat) {
        super(n, sn, e, y, cat);
    }

    public void readDrawing() {
        System.out.println("readDrawing");
    }

    public void makeFoundation() {
        System.out.println("makeFoundation");
    }
}
