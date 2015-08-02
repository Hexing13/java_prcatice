package com.hexing.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hexing on 15-8-2.
 */
public class buildxml {
    public static void main(String[] args) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("books");
        Element book1 = root.addElement("book1").addAttribute("name1","hexing1").addAttribute("author1", "hexing1");
        Element book2 = root.addElement("book2").addAttribute("name2","hexing2").addAttribute("author2","hexing2");
 /*       try {
            FileWriter writer = new FileWriter("/home/hexing/JAVA/java_Practice/src/main/java/com/hexing/xml/book.xml");
            document.write(writer);
           //flush和关闭文件流
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            XMLWriter writer = new XMLWriter(new FileWriter("/home/hexing/JAVA/java_Practice/src/main/java/com/hexing/xml/book1.xml"),format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
