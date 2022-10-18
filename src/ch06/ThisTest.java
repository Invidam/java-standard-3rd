package ch06;

class Student {
    String univName = "한국기술교육대학교";
    int grade;
    int studentId;
    double point;


    Student(int grade, int studentId, double point) {
        this.grade = grade;
        this.studentId = studentId;
        this.point = point;
    }
    Student(Student student) {
        this(student.grade, student.studentId, student.point);
    }
    public void printInfo() {
        System.out.println("=====");
        System.out.println("grade = " + grade);
        System.out.println("studentId = " + studentId);
        System.out.println("point = " + point);
        System.out.println("=====");
    }
}
public class ThisTest {

    public static void main(String[] args) {
        Student student = new Student(2, 2019136064, 4.48);
        Student copy = new Student(student);

        System.out.println("student = " + student.toString());
        student.printInfo();
        System.out.println("copy = " + copy.toString());
        copy.printInfo();
    }
}
