package ch07.InterfaceTest;

class Person {
    public void eat() {
        System.out.println("허겁지겁 맛있다~");
    }
}
class Me extends Person implements Eatable {

//    public void eat() {
//        System.out.println("맛있다~ 냠냠쩝쩝");
//    }
//    public void eat2() {
//        super.eat();
//    }
}
public class InterfaceTest {
    public static void main(String[] args) {
        Me me = new Me();
        me.eat();
//        me.eat2();
    }
}
