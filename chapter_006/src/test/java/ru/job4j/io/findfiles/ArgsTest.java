package ru.job4j.io.findfiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgsTest {

    @Test
    public void whenArgsIsInfoForSearchByMask() {
        String[] info = new String[]{"-d", "c:/", "-n", "*.txt", "-m", "-o", "log.txt"};
        Args args = new Args(info);
        Map<String, String> mapInfo = args.getInfo();
        args.init();
        assertThat(args.getDirectory(), is(mapInfo.get("-d")));
        assertThat(args.getOutput(), is(mapInfo.get("-o")));
        assertThat(args.getName(), is(mapInfo.get("-n").replaceFirst("\\*.", "")));
    }

    @Test
    public void whenArgsIsInfoForSearchByName() {
        String[] info = new String[]{"-d", "c:/", "-n", "*.txt", "-f", "-o", "log.txt"};
        Args args = new Args(info);
        Map<String, String> mapInfo = args.getInfo();
        args.init();
        assertThat(args.getDirectory(), is(mapInfo.get("-d")));
        assertThat(args.getOutput(), is(mapInfo.get("-o")));
        assertThat(args.getName(), is(mapInfo.get("-n")));
    }
}