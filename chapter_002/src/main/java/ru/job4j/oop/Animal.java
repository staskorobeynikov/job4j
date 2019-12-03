package ru.job4j.oop;

public class Animal {
    public Animal(String name) {
        super();
        System.out.println("Class name: Animal");
    }
    public static void main(String[] args) {
        Animal animal = new Animal("Predator");
        System.out.println();
        Predator predator = new Predator("Tiger");
        System.out.println();
        Tiger tiger = new Tiger("Amur");
    }
}
