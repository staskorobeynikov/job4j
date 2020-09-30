package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " движется по железнодорожным путям.");
    }

    @Override
    public void getFuel() {
        System.out.println(getClass().getSimpleName()
                + " необходимо заправить дизельным топливом.");
    }
}
