package com.urusy.news.task;

import com.urusy.news.service.DevToServiceImpl;
import com.urusy.news.service.HackerNewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewsGetterTask {

    private final HackerNewsServiceImpl hackerNewsService;
    private final DevToServiceImpl devToService;

    @Scheduled(cron = "${schedule.hacker-news}")
    public void getHackerNews() {
        log.info("Start getHackerNews");
        hackerNewsService.getBestStories();
        log.info("Finish getHackerNews");
    }

    @Scheduled(cron = "${schedule.dev-to}")
    public void getDevTo() {
        log.info("Start getDevTo");
        devToService.getTopArticles(50);
        log.info("Finish getDevTo");
    }
}
