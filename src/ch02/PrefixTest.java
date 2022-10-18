package ch02;

public class PrefixTest {

    void preFixTest() {
        int octNum = 010;
        int hexNum = 0xF;
        int binNum = 0b1001010101;

        System.out.println("octNum = " + octNum);
        System.out.println("hexNum = " + hexNum);
        System.out.println("binNum = " + binNum);

        String testNumStr = "1001010101";
        int parsed = Integer.parseInt(testNumStr,2);
        System.out.println("parsed = " + parsed);
    }
    public static void main(String[] args) {
        PrefixTest app = new PrefixTest();
        app.preFixTest();
    }
}
