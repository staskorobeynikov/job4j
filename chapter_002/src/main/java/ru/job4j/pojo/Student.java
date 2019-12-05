package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fio;
    private String groupNumber;
    private Date entered;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
