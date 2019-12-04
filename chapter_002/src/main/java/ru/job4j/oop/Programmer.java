package ru.job4j.oop;

public class Programmer extends Engineer {
    public String languageprog;
    public Programmer(String n, String sn, String e, String y, String cat, String lp) {
        super(n, sn, e, y, cat);
        this.languageprog = lp;
    }
    public String getLanguageprog() {
        return languageprog;
    }
    public void testProgramm() {

    }
    public void installsSoftware() {

    }
}
