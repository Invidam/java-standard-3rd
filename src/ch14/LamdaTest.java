package ch14;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

interface GetMax {
    int run(int a, int b);
}

public class LamdaTest {

    public static void main(String[] args) {
        int n1 = 3,  n2 = 5;
        BinaryOperator<Integer> max = (a,b) -> a > b ? a : b;
        System.out.println("max = " + max.apply(n1,n2));
    }

}
