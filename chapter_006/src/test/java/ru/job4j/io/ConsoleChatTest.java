package ru.job4j.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleChatTest {

    private PrintStream stdOut = System.out;

    private InputStream stdIn = System.in;

    private byte[] bytes = ("привет" + System.lineSeparator() + "закончить").getBytes();

    private ByteArrayInputStream in = new ByteArrayInputStream(bytes);

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void whenWorkConsoleChat() {
        System.setIn(in);
        System.setOut(new PrintStream(out));
        new ConsoleChat("./data/conversation.txt",
                "./data/botphrase.txt").init();
        assertThat(new String(out.toByteArray()), is("Bot: Hello!"
                + System.lineSeparator() + System.lineSeparator()));
        System.setIn(stdIn);
        System.setOut(stdOut);
    }
}