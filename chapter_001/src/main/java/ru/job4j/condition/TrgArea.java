package ru.job4j.condition;

public class TrgArea {

    private Point first;

    private Point second;

    private Point third;

    public TrgArea(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a,  double b, double c) {
        return (a + b + c) / 2;
    }

    public double area() {
        double result = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return result;
    }

    private boolean exist(double a, double b, double c) {
        return a + b > c && b + c > a && a + c > b;
    }

    public static void main(String[] args) {
        Point ap = new Point(0, 4);
        Point bp = new Point(10, 2);
        Point cp = new Point(9, 6);
        TrgArea trgArea = new TrgArea(ap, bp, cp);
        double out = trgArea.area();
        System.out.println(out);
    }
}
