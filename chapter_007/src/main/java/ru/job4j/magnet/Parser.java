package ru.job4j.magnet;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Parser {

    private int count = 0;

    public int parseSax(File source) {
        try {
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) {
                    if (qName.equals("entry")) {
                        count += Integer.parseInt(attributes.getValue("field"));
                    }
                }
            };
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(source, handler);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
        return count;
    }
}
