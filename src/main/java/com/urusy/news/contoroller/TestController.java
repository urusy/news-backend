package com.urusy.news.contoroller;

import com.urusy.news.code.StoriesType;
import com.urusy.news.entity.HackerNewsStoryEntity;
import com.urusy.news.messaging.PrintMessagingGateway;
import com.urusy.news.repository.HackerNewsStoryRepository;
import com.urusy.news.service.HackerNewsServiceImpl;
import com.urusy.news.service.hackernewsgateway.HackerNewsGatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class TestController {

    private final PrintMessagingGateway printMessagingGateway;
    private final HackerNewsServiceImpl hackerNewsService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        this.printMessagingGateway.send("This is test message.");

        System.out.println("Controller finished");

        return "test";
    }

    @RequestMapping(value = "/hacker-news-top", method = RequestMethod.GET)
    public List<HackerNewsStoryEntity> getHackerNewsTopStories() throws IOException {

        return hackerNewsService.getBestStories();
    }
}
