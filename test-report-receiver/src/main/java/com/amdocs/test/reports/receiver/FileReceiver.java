package com.amdocs.test.reports.receiver;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.amdocs.test.reports.constant.Constants.BUFFER_SIZE;
import static com.amdocs.test.reports.constant.Constants.TRANSFER_MAX_SIZE;

/**
 * Class to receive test data file
 */
public class FileReceiver extends Thread {

    private ServerSocket ss;
    private String outputFilePath;

    public FileReceiver(int port, String outputPath) {
        try {
            ss = new ServerSocket(port);
            outputFilePath = outputPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket clientSock = ss.accept();
                saveFile(clientSock);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile(Socket clientSock) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        byte[] buffer = new byte[BUFFER_SIZE];

        int read = 0;
        int totalRead = 0;
        int remaining = TRANSFER_MAX_SIZE;
        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
    }

}
