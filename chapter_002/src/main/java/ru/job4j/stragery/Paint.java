package ru.job4j.stragery;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());

    }
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        new Paint().draw(triangle);
        System.out.println();
        Shape square = new Square();
        new Paint().draw(square);
    }
}
