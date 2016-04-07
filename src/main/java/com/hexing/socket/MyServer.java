package com.hexing.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hexing on 16-4-6.
 */
public class MyServer extends Thread{
    private Socket socket;
    public MyServer(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            while (true){
                String str = in.readLine();
                System.out.println(str);
                out.println("has receive...");
                out.flush();
                if(str.equals("end")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6656);
        while (true){
            MyServer socket = new MyServer(server.accept());
            socket.start();
        }

    }
}
