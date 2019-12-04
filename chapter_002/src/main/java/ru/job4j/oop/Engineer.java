package ru.job4j.oop;

public class Engineer extends Profession {
    public String category;
    public Engineer(String n, String sn, String e, String y, String cat) {
        super(n, sn, e, y);
        this.category = cat;
    }
    public String getCategory() {
        return category;
    }
    public void makeInvention() {

    }
    public void optimize() {

    }
}
