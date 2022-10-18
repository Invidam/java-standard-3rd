package ch09;

class Point implements Cloneable {

    int x;
    int y;

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return obj;
    }
}

class Circle implements Cloneable {

    Point point;
    double l;

    @Override
    public String toString() {
        return "Circle{" + "point=" + point + ", l=" + l + '}';
    }

    public Circle(Point point, double l) {
        this.point = point;
        this.l = l;
    }

    public Circle deepCopy() {
        Object obj = null;
        try {
            obj = super.clone();
            Circle c = (Circle) obj;
//            c.point = (Point) this.point.clone();

            return c;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class DeepCopyTest {

    public static void baseTest() {
        Point point = new Point(3, 4);
        Circle circle = new Circle(point, 5);
        System.out.println(circle.toString());
    }

    public static void deepCopyTest() {
        Point point = new Point(3, 4);
        Circle circle = new Circle(point, 5);
        Circle copied = circle.deepCopy();
        System.out.println(circle);
        System.out.println(copied);
    }

    public static void main(String[] args) {
        deepCopyTest();
    }
}
