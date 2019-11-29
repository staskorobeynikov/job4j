package ru.job4j.ru.job4j.loop;

public class Board {
    public static void paint(int width, int height) {
        for (int row = 0; row < height; row++) {
            for (int cell = 0; cell < width; cell++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if ((row+cell)%2==0) {
                    System.out.print("X");
                } else {
                    // для наглядности пропуск заменил на "O"
                    System.out.print("O");
                }
            }
            // добавляем перевод на новую строку.
            System.out.println();
        }
    }

    public static void main(String[] args) {
        paint(3, 3);
        System.out.println();
        paint(4, 4);
        System.out.println();
        paint(5,5);
        System.out.println();
        paint(6,4);
        System.out.println();
        paint(4,6);
    }
}
