package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс предназначен для преобразования одного файла в другой
 *
 * @author STAS KOROBEYNIKOV
 * @since 27.12.2019
 */
public class Analizy {
    private String start;

    /**
     * Метод позволяет определить период, когда сервер не работал
     * @param source файл лога
     * @param target файл после анализа
     */
    public void unavailable(String source, String target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            String line;
            boolean outCycle = true;
            List<String> listLine = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            while (br.ready()) {
                line = br.readLine();
                if (!line.trim().isEmpty()) {
                    if ((line.startsWith("400") || line.startsWith("500")) && outCycle) {
                        start = line.split(" ")[1];
                        outCycle = false;
                    } else if ((line.startsWith("200") || line.startsWith("300")) && !outCycle) {
                        String finish = line.split(" ")[1];
                        result.append(String.format("%s;%s;%s", start,
                                finish, System.lineSeparator()));
                        listLine.add(result.toString());
                        result = new StringBuilder();
                        outCycle = true;
                    }
                }
            }
            writeFile(listLine, target);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void writeFile(List<String> inputList, String target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (String line : inputList) {
                writer.write(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
