package ru.job4j.magnet;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StoreXMLTest {

    @Test
    public void whenReadXMLFile() {
        Config config = new Config();
        StoreSQL str = new StoreSQL(config.init("url"));
        str.generate(2);
        List<Entry> result = str.load();
        StoreXML st = new StoreXML(new File(config.get("fileTestXML")));
        st.save(result);
        try (BufferedReader read = new BufferedReader(new FileReader(new File(config.get("fileTestXML"))))) {
            assertThat(read.readLine(), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"));
            assertThat(read.readLine(), is("<entries>"));
            assertThat(read.readLine(), is("    <entry>"));
            assertThat(read.readLine(), is("        <field>0</field>"));
            assertThat(read.readLine(), is("    </entry>"));
            assertThat(read.readLine(), is("    <entry>"));
            assertThat(read.readLine(), is("        <field>1</field>"));
            assertThat(read.readLine(), is("    </entry>"));
            assertThat(read.readLine(), is("</entries>"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}