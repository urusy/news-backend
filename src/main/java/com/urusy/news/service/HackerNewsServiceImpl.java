package com.urusy.news.service;

import com.urusy.news.code.StoriesType;
import com.urusy.news.entity.HackerNewsStoryEntity;
import com.urusy.news.repository.HackerNewsStoryRepository;
import com.urusy.news.service.hackernewsgateway.HackerNewsGatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class HackerNewsServiceImpl {


    private final HackerNewsGatewayService hackerNewsGatewayService;
    private final HackerNewsStoryRepository hackerNewsStoryRepository;

    public List<HackerNewsStoryEntity> getBestStories() {
        List<String> results = new ArrayList<>();

        var stories = hackerNewsGatewayService.getStories(StoriesType.BEST);

        var today = LocalDateTime.now();
        for (var story : stories) {
            String message = MessageFormat.format("Score = {0}, Poll = {1}, Type = {2}, Time = {3}}, Title = {4}" ,
                    story.getScore(),
                    story.getPoll(),
                    story.getType(),
                    story.getTime(),
                    story.getTitle());
            results.add(message);
            log.info(message);
        }

        // save
        for (var story : stories) {
            hackerNewsStoryRepository.save(story);
        }

        return stories;
    }
}
