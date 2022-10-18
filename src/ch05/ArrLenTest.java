package ch05;

import java.util.Arrays;

public class ArrLenTest {
    void arrLenTest() {
        int[] arr = new int[12];
        int len = arr.length;
        System.out.println("len = " + len);
    }
    void arrayItrTest() {
        int[] arr = { 1,3,6,3,2,8,4,2,1,3,1,6};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + i);
            System.out.println("arr[i] = " + arr[i]);
        }
    }
    void toStringTest() {
        int[] arr = { 1,3,6,3,2,8,4,2,1,3,1,6};
        String str = Arrays.toString(arr);
        System.out.println("str = " + str);
    }
    public static void main(String[] args) {
        ArrLenTest app = new ArrLenTest();
        app.arrLenTest();
        app.arrayItrTest();
        app.toStringTest();
    }
}
