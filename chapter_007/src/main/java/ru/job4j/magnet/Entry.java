package ru.job4j.magnet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
public class Entry {
    private int field;

    public Entry() {
    }

    public Entry(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    @XmlElement(name = "field")
    public void setField(int field) {
        this.field = field;
    }
}
