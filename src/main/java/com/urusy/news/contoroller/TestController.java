package com.urusy.news.contoroller;

import com.urusy.news.messaging.PrintMessagingGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final PrintMessagingGateway printMessagingGateway;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        this.printMessagingGateway.send("This is test message.");

        System.out.println("Controller finished");

        return "test";
    }
}
