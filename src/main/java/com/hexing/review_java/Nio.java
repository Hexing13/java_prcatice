package com.hexing.review_java;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hexing on 16-4-5.
 */
public class Nio {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("/home/hexing/a.c"));
        FileOutputStream outputStream = new FileOutputStream(new File("/home/hexing/b.c"));
        FileChannel inchannel = inputStream.getChannel();
        FileChannel outchannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){
            int eof = inchannel.read(byteBuffer);
            if(eof==-1){
                break;
            }
            byteBuffer.flip();
            outchannel.write(byteBuffer);
            byteBuffer.clear();
        }
        inchannel.close();
        outchannel.close();
        inputStream.close();
        outputStream.close();
    }
}
