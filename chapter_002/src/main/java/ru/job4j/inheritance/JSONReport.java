package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    private static final String LN = System.lineSeparator();

    @Override
    public String generate(String name, String body) {
        return "{" + LN + LN + "name : "
                + name + "," + LN
                + "body : " + body + LN + LN + "}";
    }
}
