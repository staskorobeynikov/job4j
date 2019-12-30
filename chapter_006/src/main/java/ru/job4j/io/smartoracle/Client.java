package ru.job4j.io.smartoracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Клиентская часть бота.
 *
 * @author STAS KOROBEYNIKOV
 * @since 30.12.2019
 */
public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader brClient = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        String response;
        do {
            out.println(brClient.readLine());
            response = in.readLine();
            while (!response.isEmpty()) {
                string = response;
                System.out.println(string);
                response = in.readLine();
            }
        } while (!"Bye, dear friend".equals(string));
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            new Client(socket).start();
        }
    }
}
