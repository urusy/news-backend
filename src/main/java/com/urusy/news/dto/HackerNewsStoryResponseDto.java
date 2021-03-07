package com.urusy.news.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HackerNewsStoryResponseDto {
    private long id;
    private boolean deleted;
    private String type;
    private String by;
    private long time;
    private String text;
    private boolean dead;
    private long parent;
    private long poll;
    private List<Long> kids;
    private String url;
    private long score;
    private String title;
    private List<Long> parts;
    private int descendants;
}
