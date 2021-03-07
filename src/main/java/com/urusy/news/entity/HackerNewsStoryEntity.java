package com.urusy.news.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class HackerNewsStoryEntity {
    private long id;
    private boolean deleted;
    private String type;
    private String by;
    private Date time;
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
    private String date;
}
