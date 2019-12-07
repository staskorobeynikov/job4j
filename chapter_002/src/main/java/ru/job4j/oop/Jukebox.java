package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже пешеходы по лужам\n"
                    +
                    "А вода по асфальту рекой\n"
                    +
                    "И не ясно прохожим в этот день непогожий\n"
                    +
                    "Почему я веселый такой");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят.\n"
                    +
                    "Одеяла и подушки ждут ребят.\n"
                    +
                    "Даже сказка спать ложится,\n"
                    +
                    "Чтобы ночью нам присниться.\n"
                    +
                    "Ты ей пожелай:\n"
                    +
                    "Баю-бай.");
        } else {
            System.out.println("Песня не найдена");
        }
    }
    public static void main(String[] args) {
        Jukebox song = new Jukebox();
        song.music(1);
        System.out.println();
        song.music(10);
        System.out.println();
        song.music(2);
        System.out.println();
        song.music(5);
    }
}
