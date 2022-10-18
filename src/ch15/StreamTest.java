package ch15;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamTest {

    public static void main(String[] args) throws IOException {
//        byteStreamTest();
//        fsTest();
        FileOutputStream fos = new FileOutputStream("src/ch15/numbering.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
        for (char i = '0'; i < '9'; i++) {
            bos.write(i);
        }
        fos.close();
    }

    private static void fsTest() throws IOException {
        FileInputStream fis = new FileInputStream("src/ch15/test.txt");
        FileOutputStream fos = new FileOutputStream("src/ch15/copy.txt");
        int data = 0;
        while((data = fis.read()) != -1) {
            System.out.printf(String.valueOf((char) data));
            fos.write(data);
        }
        fis.close();
        fos.close();
    }

    private static void byteStreamTest() {
        byte[] intSrc = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream inputStream = new ByteArrayInputStream(intSrc);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.out.println("Arrays.toString(intSrc) = " + Arrays.toString(intSrc));
        try {
            while(inputStream.available() > 0) {
                int len = inputStream.read(temp);
                outputStream.write(temp,0,len);
                System.out.println("Arrays.toString(temp) = " + Arrays.toString(temp));

                outSrc = outputStream.toByteArray();
                System.out.println("Arrays.toString(outSrc) = " + Arrays.toString(outSrc));
            }
        }catch (IOException e) {

        }
    }
}
