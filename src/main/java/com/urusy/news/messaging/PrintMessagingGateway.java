package com.urusy.news.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.concurrent.Future;

@MessagingGateway
public interface PrintMessagingGateway {

    @Gateway(requestChannel = "printFlow.input")
    Future<Void> send(final String payload);
}
