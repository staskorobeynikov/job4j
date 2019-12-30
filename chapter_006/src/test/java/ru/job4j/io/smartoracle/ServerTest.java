package ru.job4j.io.smartoracle;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private static final String LN = System.lineSeparator();

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenSayByeThenAskByeDearFrendAndExit() throws IOException {
        testServer("bye", String.format("Bye, dear friend%s%s", LN, LN));
    }

    @Test
    public void whenSayGoodByeThenAskByeDearFrendAndExit() throws IOException {
        testServer("good bye", String.format("Bye, dear friend%s%s", LN, LN));
    }

    @Test
    public void whenSayHiThenAskHelloDearFrendAndExit() throws IOException {
        testServer(String.format("hi%sbye", LN),
                String.format("Hello, dear friend, I'm a oracle.%s%sBye, dear friend%s%s",
                LN, LN, LN, LN));
    }

    @Test
    public void whenSayHelloOracleThenAskHelloDearFrendAndExit() throws IOException {
        testServer(String.format("hello oracle%sbye", LN),
                String.format("Hello, dear friend, I'm a oracle.%s%sBye, dear friend%s%s",
                        LN, LN, LN, LN));
    }

    @Test
    public void whenSayHelloThenAskHelloDearFrendAndExit() throws IOException {
        testServer(String.format("hello%sbye", LN),
                String.format("Hello, dear friend, I'm a oracle.%s%sBye, dear friend%s%s",
                        LN, LN, LN, LN));
    }

    @Test
    public void when3() throws IOException {
        testServer(String.format(
                "Who are you?%sbye",
                LN
        ), String.format(
                "I know everything about you.%s%sBye, dear friend%s%s",
                LN, LN, LN, LN));
    }
}