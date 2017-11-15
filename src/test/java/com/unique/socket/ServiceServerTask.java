package com.unique.socket;

import sun.plugin2.message.transport.SerializingTransport;

import java.io.*;
import java.net.Socket;

public class ServiceServerTask implements Runnable {

    private Socket socket;
    InputStream inputStream = null;
    OutputStream outputStream = null;
    BufferedReader bf = null;
    ServiceServerTask(Socket socket){
        this.socket = socket;
    }

    /**
     * 和客户端进行交互
     */
    public void run() {
        try {
            inputStream = socket.getInputStream();

            outputStream = socket.getOutputStream();

            bf = new BufferedReader(new InputStreamReader(inputStream));
 //           String line = "";
//            while((line = bf.readLine()) != null){
//                String param = line;
//            }

            //获取参数
            String param;
            while (!(param = bf.readLine()) .equals("exit") ) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(param == null) continue;
                System.out.println(param);

            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
