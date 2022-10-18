package ch15;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileTest {
    static int totalFiles = 0;
    static int totalDirectories = 0;
    public static void main(String[] args) throws IOException {

        File src = new File("src");

        printFile(src);
    }
    static void printFile(File file) {
        File[] files = file.listFiles();
        ArrayList<Integer> directoryIdx = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();

            if(files[i].isDirectory()) {
                directoryIdx.add(i);
                fileName = "[" + fileName + "]";
            }
            System.out.println(fileName);
        }

        int dirCnt = directoryIdx.size();
        int fileCnt = files.length - dirCnt;

        totalFiles += fileCnt;
        totalDirectories += dirCnt;

        System.out.println("파일 수 : " + fileCnt + " 디렉터리 수 : " + dirCnt);
        System.out.println();
        for (int idx: directoryIdx) {
            printFile(files[idx]);
        }
    }
}
