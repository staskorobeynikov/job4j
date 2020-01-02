package ru.job4j.io;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgsTest {
    @Test
    public void whenGetDirectory() {
        String[] info = new String[]{"-d", "c:/projects", "-e", "*.html", "-o", "project.zip"};
        Args args = new Args(info);
        Map<String, String> mapInfo = args.getInfo();
        String result = "c:/projects";
        assertThat(mapInfo.get("-d"), is(result));
        assertThat(args.directory(), is(result));
    }

    @Test
    public void whenGetFileExtension() {
        String[] info = new String[]{"-d", "c:/projects", "-e", "*.html", "-o", "project.zip"};
        Args args = new Args(info);
        Map<String, String> mapInfo = args.getInfo();
        String result = "*.html";
        assertThat(mapInfo.get("-e"), is(result));
        assertThat(args.exclude(), is(result.replaceFirst("\\*.", "")));
    }

    @Test
    public void whenGetNameFileArchive() {
        String[] info = new String[]{"-d", "c:/projects", "-e", "*.html", "-o", "project.zip"};
        Args args = new Args(info);
        Map<String, String> mapInfo = args.getInfo();
        String result = "project.zip";
        assertThat(mapInfo.get("-o"), is(result));
        assertThat(args.output(), is(result));
    }
}