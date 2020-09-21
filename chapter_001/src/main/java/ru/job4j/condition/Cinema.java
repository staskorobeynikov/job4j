package ru.job4j.condition;

public class Cinema {
    public static void access(int age) {
        System.out.println("The age of the customer is : " + age);
        if (age >= 18) {
            System.out.println("Welcome to the cinema.");
        } else {
            System.out.println("It is not for you.");
        }
    }

    public static void permission(boolean allowByParent, boolean hasMoney) {
        if (allowByParent && hasMoney) {
            System.out.println("I can go to the cinema.");
        } else {
            System.out.println("I can't.");
        }
    }

    public static void main(String[] args) {
        Cinema.access(21);
        Cinema.access(16);
        System.out.println();
        Cinema.permission(true, true);
        Cinema.permission(true, false);
        Cinema.permission(false, true);
        Cinema.permission(false, false);
    }
}
