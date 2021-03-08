package com.urusy.news.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class DevToArticleEntity {
    private String typeOf;
    private long id;
    private String title;
    private String description;
    private String readablePublishDate;
    private String slug;
    private String path;
    private String url;
    private long commentsCount;
    private long publicReactionsCount;
    private Long collectionId;
    private Date publishedTimestamp;
    private long positiveReactionsCount;
    private String coverImage;
    private String socialImage;
    private String canonicalUrl;
    private Date createdAt;
    private Date editedAt;
    private Date crosspostedAt;
    private Date publishedAt;
    private Date lastCommentAt;
    private List<String> tagList;
    private String tags;
    private DevToUserEntity user;
    private DevToFlareTagEntity flareTag;
    private String date;
}
