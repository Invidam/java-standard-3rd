package ch05;

import java.util.Arrays;

public class ArrCopyTest {


    public static void main(String[] args) {


//        arrCopy();

        char[] charArr = {'c','h','a','r','a','r','r'};
        String str = new String(charArr);
        char[] chars = str.toCharArray();


        printString(charArr);
        System.out.println("str = " + str);
        printString(charArr);
    }

    private static void printString(char[] charArr) {
        for(int i = 0; i< charArr.length; ++i) {
            System.out.printf(String.valueOf(charArr[i]));
        }
        System.out.println();
    }


    private static void arrCopy() {
        int srcArr[] = {1,2,3,4,5,6};
        int desArr[] = {0,0,0,0,0,0,0,0,0};
        System.arraycopy(srcArr, 0, desArr, 0, srcArr.length);

        System.out.println("srcArr = " + Arrays.toString(srcArr));
        System.out.println("desArr = " + Arrays.toString(desArr));
    }
}
