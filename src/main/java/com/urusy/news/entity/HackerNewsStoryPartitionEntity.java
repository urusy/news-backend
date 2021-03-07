package com.urusy.news.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HackerNewsStoryPartitionEntity {
    private String key;
    private List<HackerNewsStoryEntity> stories;
}
