package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 11;
        while (count >= 0) {
            System.out.println("На столе осталось: " + count + " спичек (-и, -а)");
            System.out.println("Игрок 1 введите число от 1 до трех: ");
            int selectPlayer1 = Integer.parseInt(input.nextLine());
            count = count - selectPlayer1;
            System.out.println("На столе осталось: " + count + " спичек (-и, -а)");
            if (count == 0) {
                System.out.println("Выиграл Игрок 1");
                break;
            }
            System.out.println("Игрок 2 введите число от 1 до 3");
            int selectPlayer2 = Integer.parseInt(input.nextLine());
            count = count - selectPlayer2;
            if (count == 0) {
                System.out.println("Выиграл Игрок 2");
                break;
            }
        }
    }
}
