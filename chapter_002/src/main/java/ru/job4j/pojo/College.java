package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Коробейников Стас Евгеньевич");
        student.setGroupNumber("Стажер");
        student.setEntered(new Date());
        System.out.println(student.getFio() + " учится в группе " + student.getGroupNumber());
    }
}
