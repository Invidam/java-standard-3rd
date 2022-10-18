package ch07.OverrideTest;

class Person {
    static String TYPE = "PERSON";
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {

    }

    public void eat() {
        System.out.println("밥이 맛있다~");
    }
    public void changeType() {
        TYPE = "HUMAN";
        System.out.println(TYPE);
    }
    public void print() {
        System.out.println("=== Person ===");
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("===   ===");
    }

}
class Student extends Person   {
    public int studentCode;
    public Student(int studentCode, int age, String name) {
        super();
        this.studentCode = studentCode;
        this.age = age;
        this.name = name;
    }

    public void eat() {
        System.out.println("학식 맛있다~");
    }
    public void print() {
        System.out.println("=== Student ===");
        System.out.println("studentCode = " + studentCode);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("===   ===");
    }
}
public class OverrideTest {
    public static void main(String[] args) {
        Person person = new Person(23, "박한수");
        Student me = new Student(2019136064, 23, "박한수");
        me = (Student) person;
//        person.changeType();
//        inheritTest(person, me);
    }

    private static void inheritTest(Person person, Student me) {
        person.print();

        me.print();
    }
}
