package com.hexing.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by hexing on 16-4-6.
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        BufferedReader in = null,wt = null;
        PrintWriter out = null;
        try {
            client = new Socket("127.0.0.1",6656);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(),true);
            wt = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String str = wt.readLine();
                out.println(str);
                out.flush();
                if(str.equals("end")){
                    break;
                }
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wt.close();
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
