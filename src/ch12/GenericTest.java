package ch12;

import java.util.Collections;

public class GenericTest {

    public static void main(String[] args) {
//        basicTest();
//        inheritTest();
        Box<Fruit> box = new Box<>();
        box.setItem(new Fruit());
    }

    private static void inheritTest() {
        Box<Fruit> box = new Box<>();
        box.setItem(new Fruit());
        box.setItem(new Apple());
    }

    private static void basicTest() {
        Box<String> box = new Box<>();
        box.setItem("TEST");

        Box uncheckedBox = new Box();
        uncheckedBox.setItem("TEST");
        uncheckedBox.setItem(123);
    }
}


class Box<T > {
    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
class Fruit {
    String value = "fruit";
}
class Apple extends Fruit{
    String value = "apple";
}