package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        String oracle;
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            oracle = "Да.";
        } else if (answer == 1) {
            oracle = "Нет.";
        } else {
            oracle = "Может быть.";
        }
        System.out.println(String.format("На Ваш вопрос: %s, Оракул отвечает: %s", question, oracle));
    }
}
