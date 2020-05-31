package ru.job4j.innovation;

public class Student implements  Comparable<Student> {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return (this.score - o.score);
    }

    @Override
    public String toString() {
        return String.format("Student: name = %s, score = %s", name, score);
    }
}
