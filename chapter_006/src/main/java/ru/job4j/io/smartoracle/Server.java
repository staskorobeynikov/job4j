package ru.job4j.io.smartoracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Серверная часть бота.
 *
 * @author STAS KOROBEYNIKOV
 * @since 30.12.2019
 */
public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello oracle".equals(ask) || "hi".equals(ask) || "hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if ("bye".equals(ask) || "good bye".equals(ask)) {
                out.println("Bye, dear friend");
                out.println();
            } else {
                out.println("I know everything about you.");
                out.println();
            }
        } while (!("bye".equals(ask) || "good bye".equals(ask)));
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        }
    }
}
