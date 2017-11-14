package com.unique.socket;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServiceClient {



    public static void main(String[] args) throws Exception{

            Socket socket = new Socket("localhost", 8899);

            //获取输入流

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            PrintWriter pw = new PrintWriter(outputStream);

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            pw.println(line);
            pw.flush();


            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String result = br.readLine();
            System.out.println(result);


            inputStream.close();
            outputStream.close();
            socket.close();

    }
}
