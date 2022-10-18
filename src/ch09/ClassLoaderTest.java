package ch09;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassLoaderTest {

    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends Point> aClass = new Point(3, 4).getClass();
        Constructor<? extends Point> constructor = aClass.getConstructor();
        Point point = constructor.newInstance();
        System.out.println("point = " + point);

    }
}
