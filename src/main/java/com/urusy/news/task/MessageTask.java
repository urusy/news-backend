package com.urusy.news.task;

import com.urusy.news.messaging.PrintMessagingGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MessageTask {

    private final PrintMessagingGateway printMessagingGateway;

    @Scheduled(cron = "${schedule.message}")
    public void pushMessage() {
        printMessagingGateway.send("Scheduled message! " + LocalDateTime.now());
        System.out.println("Message send.");
    }
}
