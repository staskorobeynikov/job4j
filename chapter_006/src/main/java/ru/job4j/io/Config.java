package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.StringJoiner;

/**
 * Класс позволяет прочесть файл настроек
 *
 * @author STAS KOROBEYNIKOV
 * @since 26.12.2019
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                String st = br.readLine();
                if (!st.startsWith("//") && !st.startsWith("##") && !st.isEmpty()) {
                    values.put(st.split("=")[0].trim(), st.split("=")[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String result;
        try {
            result = values.get(key);
        } catch (UnsupportedOperationException uoe) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
