package ru.job4j.magnet;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@Ignore public class ConvertXSQTTest {
    @Test
    public void whenReadConvertXSQTFile() {
        Config config = new Config();
        StoreSQL str = new StoreSQL(config.init("url"));
        str.generate(2);
        List<Entry> result = str.load();
        StoreXML st = new StoreXML(new File(config.get("fileTestXML")));
        st.save(result);
        ConvertXSQT cont = new ConvertXSQT(new File(config.get("fileTestXML")),
                new File(config.get("convertTestFileXML")), new File(config.get("schemaTestXSTL")));
        cont.convert();
        try (BufferedReader read = new BufferedReader(new FileReader(new File(config.get("convertTestFileXML"))))) {
            assertThat(read.readLine(), is("<?xml version=\"1.0\" encoding=\"UTF-8\"?><entries>"));
            assertThat(read.readLine(), is("    <entry field=\"0\"/>"));
            assertThat(read.readLine(), is("    <entry field=\"1\"/>"));
            assertThat(read.readLine(), is("</entries>"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}