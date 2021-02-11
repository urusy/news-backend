package com.urusy.news.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class PrintService {

    @ServiceActivator(inputChannel = "printFlow.input")
    public void onPrintMessage(final String payload) {

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(payload);
    }
}
