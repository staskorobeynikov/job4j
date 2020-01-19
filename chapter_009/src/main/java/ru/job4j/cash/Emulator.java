package ru.job4j.cash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Emulator {

    private Cash cash;

    public Emulator(Cash cash) {
        this.cash = cash;
    }

    private final Logger logger = LogManager.getLogger(Emulator.class.getName());

    private static final String LN = System.lineSeparator();

    public String getText(String name, List<File> fileList) {
        String result = "";
        if (fileList.contains(new File(name))) {
            if (cash.get(name) != null) {
                result = cash.get(name).get().toString();
            } else {
                cash.add(name, readFile(name));
                result = cash.get(name).get().toString();
            }
        }
        return result;
    }

    private String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                result.append(String.format("%s%s", line, LN));
            }
        } catch (IOException ioe) {
            logger.error(ioe.getMessage(), ioe);
        }
        return result.toString();
    }
}
