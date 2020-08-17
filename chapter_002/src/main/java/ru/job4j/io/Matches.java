package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 11;
        boolean player = true;
        String name = "";
        while (true) {
            name = player ? "Игрок_1" : "Игрок_2";
            System.out.println(name + " введите число от 1 до 3: ");
            int select = Integer.parseInt(input.nextLine());
            while (select < 1 || select > 3) {
                System.out.println("Вы ввели недопустимое значение. Повторите попытку.");
                select = Integer.parseInt(input.nextLine());
            }
            count = count - select;
            if (count <= 0) {
                break;
            }
            System.out.println("На столе осталось: " + count + " спичек (-и, -а).");
            player = !player;
        }
        System.out.println(String.format("Победу одержал %s!!!", name));
    }
}
