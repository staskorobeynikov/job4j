package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int i = 1;
        int j = 1;
        while (!Thread.currentThread().isInterrupted()) {
            if (rect.getX() == 290) {
                i = -1;
            }
            if (rect.getX() == 0) {
                i = 1;
            }
            if (rect.getY() == 290) {
                j = -1;
            }
            if (rect.getY() == 0) {
                j = 1;
            }
            this.rect.setX(this.rect.getX() + i);
            this.rect.setY(this.rect.getY() + j);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
