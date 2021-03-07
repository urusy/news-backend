package com.urusy.news.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewsCommonEntity {
    private String title;
    private String text;
    private String site;
    private LocalDateTime cretedAt;
    private LocalDateTime updatedAt;
}
