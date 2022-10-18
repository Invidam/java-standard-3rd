package ch02;

public class VariableRangeTest {

    void varInitValTest() {
//        char c;
//        int i;
//        long l;
//        double d;
//        System.out.println("char = " + c);
//        System.out.println("int = " + i);
//        System.out.println("long = " + l);
//        System.out.println("double = " + d);
    }
    void charRangeTest() {
        char c = (char) ((1L << 16) - 1);
        char cPlus = (char) (c + 1);
        System.out.println("c = " + (int)c);
        System.out.println("cPlus = " + cPlus);
        System.out.println("cPlus = " + (int)cPlus);
    }
    void intAndLong() {

        int intNum = (int) ((1L << 32) - 1);
        long longNum = ((1L << 63) - 1);
        long longNumNotOver = 1L << 63 -1L + 1<< 63;
        long longNumOver = longNum +1;

        int intNumOver = intNum + 1;
        System.out.println("intNum = " + intNum);
        System.out.println("intNumOver = " + intNumOver);

        System.out.println("longNum = " + longNum);
        System.out.println("longNumOver = " + longNumOver);
    }

    public static void main(String[] args) {
        VariableRangeTest app = new VariableRangeTest();
//        app.charRangeTest();
        app.intAndLong();
    }
}
