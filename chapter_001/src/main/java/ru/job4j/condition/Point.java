package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    //public static double distance(int x1, int y1, int x2, int y2) {
    private int x;
    private int y;
    private int z;
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public double distance3d(Point that) {
        double result = sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2)
                +
                pow(this.z - that.z, 2));
        return result;
    }
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        Point a3d = new Point(0, 0, 0);
        Point b3d = new Point(0, 3, 4);
        double dist3d = a3d.distance3d(b3d);
        System.out.println(dist);
        System.out.println(dist3d);
    }
}
