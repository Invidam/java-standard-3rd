package ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.TreeMap;

public class IteratorTest {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(31);
        arrayList.add(15);
        arrayList.add(71);
        arrayList.add(64);
        arrayList.add(6);
        arrayList.add(99);
        ListIterator iterator = arrayList.listIterator();

//        System.out.println("iterator.next() = " + iterator.next());
//        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("arrayList = " + arrayList.toString());
//        iterator.add(1111);
        iterator.remove();
        System.out.println("arrayList = " + arrayList.toString());
//        System.out.println("iterator.previous() = " + iterator.previous());
//        iterator.add(2222);
////        iterator.set(1234);
//
//        System.out.println("arrayList = " + arrayList.toString());

    }
}
