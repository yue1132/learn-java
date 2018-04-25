package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(8181)) {
                //wart for client connection
                try (Socket accept = serverSocket.accept()) {

                    InputStream inputStream = accept.getInputStream();
                    OutputStream outputStream = accept.getOutputStream();

                    try (Scanner in = new Scanner(inputStream, "UTF-8")) {
                        PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                        out.println("Hello! Enter BYE to exit!");

                        //echo client input
                        boolean done = false;
                        while (!done && in.hasNextLine()) {
                            String line = in.nextLine();
                            out.println("Echo:" + line);
                            if (line.trim().equals("BYE")) done = true;
                        }
                    }


                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
