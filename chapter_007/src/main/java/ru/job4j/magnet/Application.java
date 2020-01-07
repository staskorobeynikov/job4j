package ru.job4j.magnet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Application {
    private StoreSQL storeSQL;
    private StoreXML storeXML;
    private ConvertXSQT convertXSQT;
    private static int count;
    private File source;

    public Application(StoreSQL storeSQL, StoreXML storeXML, ConvertXSQT convertXSQT, File source) {
        this.storeSQL = storeSQL;
        this.storeXML = storeXML;
        this.convertXSQT = convertXSQT;
        this.source = source;
    }

    public int parsing(int number) {
        storeSQL.generate(number);
        storeXML.save(storeSQL.load());
        convertXSQT.convert();
        parseSax();
        return getCount();
    }

    public static int getCount() {
        return count;
    }

    public void parseSax() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParcer = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {
                    if (qName.equals("entry")) {
                        count += Integer.parseInt(attributes.getValue("field"));
                    }
                }
            };
            saxParcer.parse(source, handler);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
}
