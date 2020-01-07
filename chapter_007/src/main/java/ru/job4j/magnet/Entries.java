package ru.job4j.magnet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entries")
public class Entries {
    private List<Entry> list;

    public Entries() {
    }

    public Entries(List<Entry> list) {
        this.list = list;
    }

    public List<Entry> getList() {
        return list;
    }

    public void setList(List<Entry> list) {
        this.list = list;
    }


}
