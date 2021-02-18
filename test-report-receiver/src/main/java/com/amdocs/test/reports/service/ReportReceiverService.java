package com.amdocs.test.reports.service;

import com.amdocs.test.reports.receiver.FileReceiver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ReportReceiverService {

    @Value("${socket.port}")
    private Integer socketPort;

    @Value("${receiver.outputFilePath}")
    private String testOutputFilePath;

    @PostConstruct
    public void receiveTestReport() {

        try {
            FileReceiver fs = new FileReceiver(socketPort,testOutputFilePath);
            fs.start();
        } catch (Exception e) {

        }

    }
}
