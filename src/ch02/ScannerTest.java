package ch02;

import java.util.Scanner;

public class ScannerTest {

    void inputNum() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);

        System.out.println("num = " + num);
    }
    public static void main(String[] args) {
        ScannerTest app = new ScannerTest();
        app.inputNum();
    }
}
