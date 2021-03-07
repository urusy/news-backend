package com.urusy.news.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.urusy.news.entity.DevToFlareTagEntity;
import com.urusy.news.entity.DevToUserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class DevToArticleResponseDto {
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
    private OffsetDateTime publishedTimestamp;
    @JsonProperty("positive_reactions_count")
    private long positiveReactionsCount;
    @JsonProperty("cover_image")
    private String coverImage;
    @JsonProperty("social_image")
    private String socialImage;
    @JsonProperty("canonical_url")
    private String canonicalUrl;
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    @JsonProperty("edited_at")
    private OffsetDateTime editedAt;
    @JsonProperty("crossposted_at")
    private OffsetDateTime crosspostedAt;
    @JsonProperty("published_at")
    private OffsetDateTime publishedAt;
    @JsonProperty("last_comment_at")
    private OffsetDateTime lastCommentAt;
    @JsonProperty("tag_list")
    private List<String> tagList;
    private String tags;
    private DevToUserEntity user;
    @JsonProperty("flare_tag")
    private DevToFlareTagEntity flareTag;
}
