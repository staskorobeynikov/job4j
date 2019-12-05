package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String FIO;
    private String groupNumber;
    private Date entered;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Date getEntered() {
        return entered;
    }

    public void setEntered(Date entered) {
        this.entered = entered;
    }
}
