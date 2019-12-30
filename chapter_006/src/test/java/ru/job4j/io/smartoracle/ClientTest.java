package ru.job4j.io.smartoracle;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {

    private static final String LN = System.lineSeparator();

    private void testClient(String in, String out) throws IOException {
        Socket socket = mock(Socket.class);
        InputStream stdIn = System.in;
        ByteArrayInputStream inpConsole = new ByteArrayInputStream(out.getBytes());
        System.setIn(inpConsole);
        ByteArrayOutputStream goToServer = new ByteArrayOutputStream();
        ByteArrayInputStream returnToClient = new ByteArrayInputStream(in.getBytes());
        when(socket.getInputStream()).thenReturn(returnToClient);
        when(socket.getOutputStream()).thenReturn(goToServer);
        Client client = new Client(socket);
        client.start();
        assertThat(goToServer.toString(), is(out));
        System.setIn(stdIn);
    }

    @Test
    public void whenByeOracle() throws IOException {
        testClient(String.format(
                "%s%s%s", "Bye, dear friend",
                LN,
                LN), String.format(
                        "%s%s", "bye", LN));
    }

    @Test
    public void whenHelloOracle() throws IOException {
        testClient(String.format(
                "%s%s%s%s%s%s", "Hello, dear friend, I'm a oracle.",
                LN,
                LN,
                "Bye, dear friend",
                LN,
                LN), String.format(
                "%s%s%s%s", "hello oracle", LN, "hi", LN));
    }

    @Test
    public void whenOtherAsk() throws IOException {
        testClient(String.format(
                "%s%s%s%s%s%s", "I know everything about you.",
                LN,
                LN,
                "Bye, dear friend",
                LN,
                LN), String.format(
                "%s%s%s%s", " ", LN, "bye", LN));
    }
}