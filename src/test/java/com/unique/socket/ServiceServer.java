package com.unique.socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.Executor;

public class ServiceServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket();

        serverSocket.bind(new InetSocketAddress("localhost",8899));


        //接受请求

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ServiceServerTask(socket)).start();
        }


    }
}
