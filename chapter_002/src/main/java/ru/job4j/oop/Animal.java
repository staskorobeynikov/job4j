package ru.job4j.oop;

public class Animal {
    public Animal() {
        super();
        System.out.println("Class name: Animal");
    }
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println();
        Predator predator = new Predator();
        System.out.println();
        Tiger tiger = new Tiger();
    }
}
