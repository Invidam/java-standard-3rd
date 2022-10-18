package ch12;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    int count() default 1;
    String testBy();
    String[] testTools();
    Datetime testDate();
}

@interface Datetime {
    String yymmdd();
    String hhmmss();
}




@TestInfo(
    testBy ="Park", testTools = {"SELFTEST", "MyTest"},
    testDate = @Datetime(yymmdd = "220819", hhmmss = "151555")
)
public class AnnotationTest {

    public static void main(String[] args) {
        TestInfo annotation = (TestInfo) AnnotationTest.class.getAnnotation(TestInfo.class);
        System.out.println("annotation = " + annotation.count());
        System.out.println("annotation = " + annotation);
    }
}