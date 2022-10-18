package ch08.ExceptionTest;

public class ExceptionTest {

    public static void makeException() {
        int tmp = 0 / 0;
    }

    public static void main(String[] args) {
        System.out.println(exceptionTest());
    }

    private static int exceptionTest() {
        try {
            makeException();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());
            return 2;
        } finally {
            System.out.println("FINAL");
            return 3;
        }
//        System.out.println("END");
//        return 4;
    }
}
