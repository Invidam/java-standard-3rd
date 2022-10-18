package ch07.BindingTest;
abstract class Person {
    int studentCode =2019132123;
    int age = 23;
    String name = "장성준";

    public Person() {}

    public void print() {
        System.out.println("=== Person ===");
        System.out.println("studentCode = " + this.studentCode);
        System.out.println("age = " + this.age);
        System.out.println("name = " + this.name);
        System.out.println("===   ===");
    }

}
class Student extends Person {
    int studentCode =2019136064;
    int age = 23;
    String name = "박한수";

    public Student() {

    }
    public void eat() {
        System.out.println("학식 맛있다~");
    }
    public void print() {
        System.out.println("=== Student ===");
        System.out.println("studentCode = " + this.studentCode);
        System.out.println("age = " + this.age);
        System.out.println("name = " + this.name);
        System.out.println("===   ===");
    }
}
public class BindingTest {

    public static void main(String[] args) {

        Person person = new Student();
        Student me = new Student();

        infoTest(person,me );
    }
    private static void infoTest(Person person, Student me) {
        System.out.println("person.name = " + person.name);
        person.print();

        me.print();
        System.out.println("me = " + me.name);
    }
}
