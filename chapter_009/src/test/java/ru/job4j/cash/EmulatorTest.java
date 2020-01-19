package ru.job4j.cash;

import org.junit.Test;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmulatorTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenNotCreateInPath() {
        Cash cash = new Cash();
        Emulator emulator = new Emulator(cash);
        String pathName = "./data";
        File file = new File(pathName);
        List<File> fileList = new ArrayList<>();
        fileList.addAll(Arrays.asList(file.listFiles()));

        String result = emulator.getText("./data/111.txt", fileList);

        assertThat(result, is(""));

    }

    @Test
    public void whenReadFileInPathAndGetTextInCash() {
        Cash cash = new Cash();
        Emulator emulator = new Emulator(cash);
        String pathName = "./data";
        File file = new File(pathName);
        List<File> fileList = new ArrayList<>();
        fileList.addAll(Arrays.asList(file.listFiles()));
        emulator.getText("./data/Names.txt", fileList);

        SoftReference result = cash.get("./data/Names.txt");

        assertThat(result.get(), is(
                String.format("Name1%sName2%sName3%sName4%s",
                        LN,
                        LN,
                        LN,
                        LN))
        );
    }

    @Test
    public void whenReadFileGetTextInEmulator() {
        Cash cash = new Cash();
        Emulator emulator = new Emulator(cash);
        String pathName = "./data";
        File file = new File(pathName);
        List<File> fileList = new ArrayList<>();
        fileList.addAll(Arrays.asList(file.listFiles()));

        String result = emulator.getText("./data/Names.txt", fileList);

        assertThat(result, is(
                String.format("Name1%sName2%sName3%sName4%s",
                        LN,
                        LN,
                        LN,
                        LN))
        );
    }

    @Test
    public void whenCashContainsFile() {
        Cash cash = new Cash();
        Emulator emulator = new Emulator(cash);
        String pathName = "./data";
        File file = new File(pathName);
        List<File> fileList = new ArrayList<>();
        fileList.addAll(Arrays.asList(file.listFiles()));
        emulator.getText("./data/Names.txt", fileList);

        String result = emulator.getText("./data/Names.txt", fileList);

        assertThat(result, is(
                String.format("Name1%sName2%sName3%sName4%s",
                        LN,
                        LN,
                        LN,
                        LN))
        );
    }
}