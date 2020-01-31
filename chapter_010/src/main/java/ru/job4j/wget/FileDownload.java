package ru.job4j.wget;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {

    private void downloadFile(String url, int downloadSpeed) {
        String[] urlSplit = url.split("/");
        String downloadFileName = String.format("tmp_%s", urlSplit[urlSplit.length - 1]);
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(downloadFileName)) {
            byte[] dataBuffer = new byte[downloadSpeed * 1024];
            int bytesRead;
            long start = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, downloadSpeed * 1024)) != -1) {
                long finish = System.currentTimeMillis();
                if ((finish - start) > 1000) {
                    Thread.sleep(finish - start);
                    start = System.currentTimeMillis();
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You didn't enter any input arguments.");
        } else {
            int speed = Integer.parseInt(args[1]);
            new FileDownload().downloadFile(args[0], speed);
        }
    }
}
