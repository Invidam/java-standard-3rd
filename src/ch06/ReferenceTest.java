package ch06;

import java.lang.reflect.Array;
import java.util.Arrays;

class Date {int d;}
public class ReferenceTest {
    public static void main(String[] args) {

        stringTest();
//        objectTest();
//        arrayTest();

    }

    private static void objectTest() {
        Date date = new Date();
        date.d = 123;

        referenceCall(date);
        System.out.println("date.d = " + date.d);
    }

    private static void arrayTest() {
        int[] arr= {1,2,3};
        referenceCall(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
    private static void stringTest() {
        String str = "hello world!";
        referenceCall(str);
        System.out.println("str = " + str);
    }

    static void referenceCall(Date date) {
        date.d = 456;
        System.out.println("date = " + date.d);
    }
    static void referenceCall(String str) {
        str = "Bye world!";
        System.out.println("str = " + str);
    }
    static void referenceCall(int[] arr) {
        arr[1] = 4;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
