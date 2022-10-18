package ch14;

import static java.util.stream.Collectors.counting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
//        streamTest();
        String[] arr = {"TEST", "FOR", "STUDY"};
        Stream<String> stream = Stream.of(arr);
        String s = stream.collect(new MyCollector());
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("s = " + s);
    }

    private static void streamTest() {
        randomTest();
        iterateTest();
        generateTest();
        emptyTest();
        reduceTest();
        Stream<Student> stream = getStudentStream();
        groupingTest(stream);
        partitionBySexTest(stream);
        partitionCntBySexTest(stream);
    }

    private static void groupingTest(Stream<Student> stream) {
        Map<String, List<Student>> listMap = stream.collect(
            Collectors.groupingBy(student -> student.getDepartment()));
        List<Student> 컴퓨터공학부 = listMap.get("컴퓨터공학부");
        List<Student> 전기과 = listMap.get("전기과");
        컴퓨터공학부.forEach(System.out::println);
        전기과.forEach(System.out::println);
    }

    private static void partitionCntBySexTest(Stream<Student> stream) {
        Map<Boolean, Long> stdBySex = stream.collect(
            Collectors.partitioningBy(Student::isMale, counting()));
        Long maleStd = stdBySex.get(true);
        Long femaleStd = stdBySex.get(false);
        System.out.println("maleStd = " + maleStd);
        System.out.println("femaleStd = " + femaleStd);
    }

    private static Stream<Student> getStudentStream() {
        return Stream.of(
            new Student("ret", true, 23, "컴퓨터공학부"),
            new Student("dret", false, 21, "전기과"),
            new Student("gdfg", true, 21, "컴퓨터공학부"),
            new Student("gf", true, 23, "전기과"),
            new Student("dfb", false, 21, "디자인공학과"),
            new Student("dbds", true, 23, "산업경영학과"),
            new Student("xv", true, 23, "컴퓨터공학부"),
            new Student("werq", false, 21, "디자인공학과"),
            new Student("adf", false, 22, "컴퓨터공학부"),
            new Student("asdf", false, 23, "컴퓨터공학부"),
            new Student("dfgdfg", true, 23, "전기과"),
            new Student("sdgfg", true, 23, "산업경영학과"),
            new Student("vcbx", true, 21, "디자인공학과"),
            new Student("asdasd", false, 24, "컴퓨터공학부"),
            new Student("tret", true, 23, "컴퓨터공학부"),
            new Student("qweqwe", false, 23, "전기과"),
            new Student("ngdffg", true, 23, "컴퓨터공학부"),
            new Student("hdfg", false, 26, "컴퓨터공학부"),
            new Student("asda", true, 23, "전기과"),
            new Student("bvbvs", true, 23, "컴퓨터공학부"),
            new Student("zxc", true, 24, "산업경영학과"),
            new Student("bbbbbbb", true, 23, "전기과"),
            new Student("fdsgs", true, 23, "디자인공학과"));
    }

    private static void partitionBySexTest(Stream<Student> stream) {
        Map<Boolean, List<Student>> stdBySex = stream.collect(
            Collectors.partitioningBy(Student::isMale));
        List<Student> maleStd = stdBySex.get(true);
        List<Student> femaleStd = stdBySex.get(false);
        maleStd.stream().forEach(System.out::println);
        femaleStd.stream().forEach(System.out::println);
    }

    private static void reduceTest() {
        int[] arr = {123,43265934,2344,234,123,7,6,33,4,45,3};
        int sum = IntStream.of(arr).reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);
    }

    private static void emptyTest() {
        Optional<String> str1 = Optional.of("12345");
        Optional<String> str2 = Optional.of("");

        Optional<String> optionalS = str1.filter(x -> {
            System.out.println("x = " + x);
            return x.length() > 0;
        });
        Optional<String> optionalS2 = str2.filter(x -> {
            System.out.println("x = " + x);
            return x.length() > 0;
        });
    }

    static int strToInt(String str) {
        Optional<String> optionalS = Optional.ofNullable(str);
        return optionalS.map(Integer::parseInt).orElse(-1);
    }
    private static void generateTest() {
        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(5).forEach(System.out::println);
    }

    private static void iterateTest() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 3);
        stream.limit(5).forEach(System.out::println);
    }

    private static void randomTest() {
        IntStream stream = new Random().ints();
        stream.limit(5).forEach(System.out::println);
    }
}

class Student {
    String name;
    boolean isMale;
    int age;
    String department;
    int point;

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", isMale=" + isMale +
            ", age=" + age +
            ", department='" + department + '\'' +
            ", point=" + point +
            '}';
    }

    public Student(String name, boolean isMale, int age, String department) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.department = department;
        this.point = (int) (Math.random() * 100 )+ 1;
    }
}

class MyCollector implements Collector<String, StringBuilder, String> {

    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb, s) -> {
            sb.append(" + ");
            sb.append(s);
        };
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb, s) -> sb.append(s);
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return s -> s.toString();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}