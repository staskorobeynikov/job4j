package ru.job4j.magnet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class Application {
    private static int count;
    private File source;

    public Application(File source) {
        this.source = source;
    }

    public static int parse(int generate) {
        Config config = new Config();
        StoreSQL str = new StoreSQL(config.init("url"));
        str.generate(generate);
        List<Entry> result = str.load();
        StoreXML st = new StoreXML(new File(config.get("fileXML")));
        st.save(result);
        ConvertXSQT cont = new ConvertXSQT(new File(config.get("fileXML")),
                new File(config.get("convertFileXML")), new File(config.get("schemaXSTL")));
        cont.convert();
        Application app = new Application(new File(config.get("convertFileXML")));
        app.parseSax();
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

    public static void main(String[] args) {
        System.out.println(parse(10000));
    }
}
