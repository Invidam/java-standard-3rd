package ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

    public static void main(String[] args)  {
        InetAddressTestFun();

    }

    private static void InetAddressTestFun() {
        try {
            InetAddress ip = null;
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("ip.getHostName() = " + ip.getHostName());
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress());
            System.out.println("ip = " + ip);

            ip = InetAddress.getLocalHost();
            System.out.println("ip.getHostName() = " + ip.getHostName());
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress());
            System.out.println("ip = " + ip);

            InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
            Arrays.stream(ipArr).forEach(System.out::println);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
