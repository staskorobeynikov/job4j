package ru.job4j.poly;

public class College {
    public static void main(String[] args) {
        // Создаем объект класса Freshman
        Freshman freshman = new Freshman();
        // делаем приведение к типу родителя Student
        Student student = freshman;
        // Делаем приведение к типу родителя Object
        Object object = freshman;
    }
}
