package ru.job4j.oop;

public class Animal {
    public String name;

    public Animal() {
        System.out.println("Class name: Animal");
    }

    public Animal(String name) {
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Predator");
        Animal animal1 = new Animal();
        System.out.println();
        Predator predator = new Predator("Tiger");
        Predator predator1 = new Predator();
        System.out.println();
        Tiger tiger = new Tiger("Amur");
        Tiger tiger1 = new Tiger();
    }
}
