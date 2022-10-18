package ch06;

public class VarArgsTest {

    public static void main(String[] args) {
        int sum = getSum(1,2,3,4,5,6,7,8,9,10);
        System.out.println("sum = " + sum);
    }

    static int getSum(int... rest) {
        int sum = 0;
        for (int num: rest
             ) {
            sum += num;
        }
        return sum;
    }
}
