package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Консольный чат
 *
 * @author STAS KOROBEYNIKOV
 * @since 30.12.2019
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String inputLine = "";
            String answer;
            StringBuilder dialogText;
            boolean botAnswerOurMessage = true;
            while (!(OUT.equals(inputLine))) {
                inputLine = br.readLine();
                dialogText = new StringBuilder(String.format("User: %s%s", inputLine,
                        System.lineSeparator()));
                if (STOP.equals(inputLine)) {
                    botAnswerOurMessage = false;
                }
                if (OUT.equals(inputLine) || CONTINUE.equals(inputLine)) {
                    botAnswerOurMessage = true;
                } else if (botAnswerOurMessage) {
                    answer = String.format("Bot: %s%s", getAnswerBot(), System.lineSeparator());
                    dialogText.append(answer);
                    System.out.println(answer);
                }
                bw.write(dialogText.toString());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Метод получает ответ из списка фраз случайным образом.
     */
    public String getAnswerBot() {
        List<String> list;
        String answer = "";
        try (BufferedReader read = new BufferedReader(new FileReader(botAnswers))) {
            list = read.lines().collect(Collectors.toList());
            int i = new Random().nextInt(list.size());
            answer = list.get(i);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(String.format("Возможны следующие дейтсвия.\n"
                + "1. Бот перестанет отвечать, введите: %s |\n"
                + "2. Бот возобновит работу, введите: %s |\n"
                + "3. Закончить работу с чатом, введите: %s |\n", STOP, CONTINUE, OUT));
        ConsoleChat cc = new ConsoleChat("chapter_006/data/conversation.txt",
                "chapter_006/data/botphrase.txt");
        cc.init();
    }
}
