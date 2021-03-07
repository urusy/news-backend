package com.urusy.news.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class DevToArticleEntity {
    @JsonProperty("type_of")
    private String typeOf;
    private long id;
    private String title;
    private String description;
    @JsonProperty("readable_publish_date")
    private String readablePublishDate;
    private String slug;
    private String path;
    private String url;
    @JsonProperty("comments_count")
    private long commentsCount;
    @JsonProperty("public_reactions_count")
    private long publicReactionsCount;
    @JsonProperty("collection_id")
    private Long collectionId;
    @JsonProperty("published_timestamp")
    private Date publishedTimestamp;
    @JsonProperty("positive_reactions_count")
    private long positiveReactionsCount;
    @JsonProperty("cover_image")
    private String coverImage;
    @JsonProperty("social_image")
    private String socialImage;
    @JsonProperty("canonical_url")
    private String canonicalUrl;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("edited_at")
    private Date editedAt;
    @JsonProperty("crossposted_at")
    private Date crosspostedAt;
    @JsonProperty("published_at")
    private Date publishedAt;
    @JsonProperty("last_comment_at")
    private Date lastCommentAt;
    @JsonProperty("tag_list")
    private List<String> tagList;
    private String tags;
    private DevToUserEntity user;
    @JsonProperty("flare_tag")
    private DevToFlareTagEntity flareTag;
}
