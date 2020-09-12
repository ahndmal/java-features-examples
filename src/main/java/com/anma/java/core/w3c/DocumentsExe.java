package com.anma.java.core.w3c;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DocumentsExe {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        document.createElement("html");

        Document document2 = builder.parse("https://www.codota.com/code/java/classes/org.w3c.dom.Document");
        System.out.println(document2.getDocumentElement().getAttribute("section"));

//        Document document3 = builder.parse(new ByteArrayInputStream("<html><head><title>This is title</title></head><>bodyThis is body</body></html>".getBytes()));
//        System.out.println(document3.getDocumentElement());
    }
}
