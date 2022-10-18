package ch16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class URLConnectTest {
    public static void main(String[] args) {
        URL url = null;
        String address = "https://www.naver.com/";
        try {
            url = new URL(address);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            File file = new File("src/ch16/naver.html");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            String line;
            while((line= reader.readLine()) != null) {
                System.out.println(line);
                fos.write(line.getBytes());
            }
            fos.close();

//            connTest(url);
        } catch(Exception e) {e.printStackTrace();}
    }

    private static void connTest(URL url) throws IOException {
        URLConnection conn = url.openConnection();
        System.out.println("conn = " + conn);
        System.out.println("conn.getAllowUserInteraction() = " + conn.getAllowUserInteraction());
        System.out.println("conn.getConnectTimeout() = " + conn.getConnectTimeout());
        System.out.println("conn.getContent() = " + conn.getContent());
    }

}
