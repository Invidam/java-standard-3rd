package ch16;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientSocketTest {

    public static void main(String[] args) {
        String serverIp = "127.0.0.1";

        try {
            System.out.println("서버에 연결 중. IP: " + serverIp);
            Socket socket = new Socket(serverIp, 1557);

            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            System.out.println("readUTF = " + dataInputStream.readUTF());
            System.out.println("연결 종료 시작");

            dataInputStream.close();
            socket.close();
            System.out.println("연결 종료 완료");
        }
        catch (Exception e) {e.printStackTrace();}
    }

}
