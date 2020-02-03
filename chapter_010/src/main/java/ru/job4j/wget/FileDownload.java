package ru.job4j.wget;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileDownload {

    private final int downloadSpeed;

    private FileDownload(int downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    private void downloadFile(String url) {
        String[] urlSplit = url.split("/");
        String downloadFileName = String.format("tmp_%s", urlSplit[urlSplit.length - 1]);
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(downloadFileName)) {
            byte[] dataBuffer = new byte[downloadSpeed * 1024];
            int bytesRead;
            long start = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, downloadSpeed * 1024)) != -1) {
                long finish = System.currentTimeMillis();
                if ((finish - start) < 1000) {
                    Thread.sleep(finish - start);
                    start = System.currentTimeMillis();
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void start(String[] args) {
        List<String> urls = getList(args);
        for (String url : urls) {
            downloadFile(url);
        }
    }

    private List<String> getList(String[] args) {
        List<String> result = new ArrayList<>();
        for (String argument : args) {
            if (argument.startsWith("https")) {
                result.add(argument);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You didn't enter any input arguments.");
        } else {
            int speed = Integer.parseInt(args[args.length - 1]);
            new FileDownload(speed).start(args);
        }
    }
}
