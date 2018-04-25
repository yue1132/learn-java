package com.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 */
public class SocketTest {
    public static void main(String[] args) {

        simpleSocket1();

        simpleSocket2();

        inetAddressTest("www.baidu.com");

        inetAddressTest(null);
    }

    private static void inetAddressTest(String host) {
        if (host != null) {
            try {
                InetAddress[] addresses = InetAddress.getAllByName(host);
                for (InetAddress address : addresses) {
                    System.out.println(address);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        } else{
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println(localHost);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    private static void simpleSocket2() {
        int timeout = 10000;
        //解决直接使用new Socket(host,port)方式，会一直无限期的阻塞，知道建立了到达主机的初始连接为。
        try (Socket socket = new Socket();) {//使用无连接的套接字，然后再使用一个超时来进行连接的方式解决这个问题。
            socket.connect(new InetSocketAddress("ntp-d.nist.gov", 13), timeout);//
            try (Scanner scanner = new Scanner(socket.getInputStream())) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleSocket1() {
        try (Socket socket = new Socket("ntp-d.nist.gov", 13);
             Scanner in = new Scanner(socket.getInputStream(), "UTF-8")) {
            socket.setSoTimeout(10000);//time out after 10 seconds
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
