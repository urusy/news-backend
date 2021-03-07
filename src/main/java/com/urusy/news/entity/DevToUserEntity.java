package com.urusy.news.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DevToUserEntity {
    private String name;
    private String username;
    @JsonProperty("twitter_username")
    private String twitterUsername;
    @JsonProperty("github_username")
    private String githubUsername;
    @JsonProperty("website_url")
    private String websiteUrl;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("profile_image_90")
    private String profileImage90;
}
