package ch12;

import ch12.Direction.Value;

public class EnumTest {

    public static void main(String[] args) {
        Value east = Value.EAST;
        System.out.println(east);

    }
}


class Direction {

    enum Value {
        EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");
        private final int value;
        private final String symbol;
        Value(int i, String s) {
            this.value = i;
            this.symbol = s;
        }
    }

}