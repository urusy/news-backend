package com.urusy.news.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevToFlareTagEntity {
    private String name;
    @JsonProperty("bg_color_hex")
    private String bgColorHex;
    @JsonProperty("text_color_hex")
    private String textColorHex;
}
