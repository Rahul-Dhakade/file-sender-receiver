package com.amdocs.test.reports.service;


import com.amdocs.test.reports.sender.FileSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ReportSenderService {

    @Value("${sender.testResultFile}")
    private String testResultFile;

    @Value("${receiver.socket.port}")
    private Integer socketPort;

    @Value("${receiver.host}")
    private String receiverHost;


    //Test results will be sent to every week on monday
    @Scheduled(cron = "0 0 * * MON")
    public void sentTestReport() {
        try {
            FileSender fc = new FileSender(receiverHost, socketPort, testResultFile);
        } catch (Exception e) {

        }

    }
}
