package com.urusy.news.code;

public enum StoriesType {
    NEW("newstories"),
    TOP("topstories"),
    BEST("beststories");

    private final String code;

    StoriesType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
