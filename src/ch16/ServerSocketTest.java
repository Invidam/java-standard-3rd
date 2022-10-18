package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerSocketTest {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1557);
            System.out.println(getTime() + "서버 준비 완료");
        }catch(IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                System.out.println(getTime() + "연결 요청 대기");

                Socket socket = serverSocket.accept();
                System.out.println(getTime() + "연결 요청");
                System.out.println("socket.getPort() = " + socket.getPort());
                System.out.println("socket.getLocalPort() = " + socket.getLocalPort());


                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                dataOutputStream.writeUTF("[Notice] Test Message1 from Server.");
                System.out.println(getTime() + "데이터 전송 완료.");

                dataOutputStream.close();
                socket.close();
            } catch (IOException e) {e.printStackTrace();}
        }
    }
    private static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }

}
