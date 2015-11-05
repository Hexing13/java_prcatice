package com.hexing.review_java;

import java.io.*;

/**
 * Created by hexing on 15-10-29.
 */
public abstract class BeanUtil {
    @SuppressWarnings("unchecked")
    public static Administrator cloneTo(Administrator src){
        ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();

        ObjectOutputStream out = null;

        ObjectInputStream in = null;

        Administrator dist = null;

        try {

            out = new ObjectOutputStream(memoryBuffer);

            out.writeObject(src);

            out.flush();

            in = new ObjectInputStream(new ByteArrayInputStream(memoryBuffer.toByteArray()));

            dist = (Administrator) in.readObject();

        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {

            if (out != null)
                try {
                    out.close();

                    out = null;

                } catch (IOException e) {

                    throw new RuntimeException(e);

                }

            if (in != null)

                try {

                    in.close();

                    in = null;

                } catch (IOException e) {

                    throw new RuntimeException(e);

                }

        }
        return dist;
    }
}
