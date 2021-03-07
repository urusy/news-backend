package com.urusy.news.task;

import com.urusy.news.service.HackerNewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class MessageTask {

    private final HackerNewsServiceImpl hackerNewsService;

    @Scheduled(cron = "${schedule.hacker-news}")
    public void getHackerNews() {
        log.info("Start getHackerNews");
        hackerNewsService.getBestStories();
        log.info("Finish getHackerNews");
    }
}
