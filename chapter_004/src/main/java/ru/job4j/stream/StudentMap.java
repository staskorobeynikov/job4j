package ru.job4j.stream;

public class StudentMap {
    private Student student;
    private String surname;

    public StudentMap(Student student, String surname) {
        this.student = student;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return student.getScore();
    }

    @Override
    public String toString() {
        return "StudentMap: "
                + "student = " + student
                + ", surname = " + surname;
    }
}
