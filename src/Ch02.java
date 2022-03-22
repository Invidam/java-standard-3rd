import java.util.*;

public class Ch02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 입력");
        String input1 = scanner.nextLine();
        int num1 = Integer.parseInt(input1);
        System.out.println("\n정수 입력");
        String input2 = scanner.nextLine();
        int num2 = Integer.parseInt(input2);
        System.out.println("\n합 출력");
        System.out.println(num1 + num2);
    }
}
