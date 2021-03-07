package com.urusy.news.service.hackernewsgateway;

import com.urusy.news.code.StoriesType;
import com.urusy.news.entity.HackerNewsStoryEntity;

import java.util.List;

public interface HackerNewsGatewayService {

    List<HackerNewsStoryEntity> getStories(StoriesType storiesType);
}
