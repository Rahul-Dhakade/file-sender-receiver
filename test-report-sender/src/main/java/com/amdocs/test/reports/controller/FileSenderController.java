package com.amdocs.test.reports.controller;

import com.amdocs.test.reports.service.ReportSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileSenderController {

    @Autowired
    private ReportSenderService reportSenderService;

    @GetMapping("/file/send")
    public ResponseEntity<?> sendFile(){
        reportSenderService.sentTestReport();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
