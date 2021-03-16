package com.urusy.news.service.devtogateway;

import com.urusy.news.dto.DevToArticleResponseDto;
import com.urusy.news.entity.DevToArticleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class DevToGatewayServiceImpl {

    // todo dev.to用のRestTemplateを作成する
    @Value("${service.dev-to.api-key}")
    private String apiKey;

    public List<DevToArticleEntity> getTopArticles(int limit) {

        final HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", apiKey);
        headers.set("User-Agent", "Batch");
        final HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://dev.to/api/articles?state=rising&top>=" + limit;

        var response = restTemplate.exchange(url, HttpMethod.GET, entity, DevToArticleResponseDto[].class);

        List<DevToArticleEntity> articles = new ArrayList<>();
        DevToArticleEntity article;

        for (var item : response.getBody()) {
            var publishedAt = item.getPublishedAt().plusHours(9);

            article = DevToArticleEntity.builder()
                    .typeOf(item.getTypeOf())
                    .id(item.getId())
                    .title(item.getTitle())
                    .description(item.getDescription())
                    .readablePublishDate(item.getReadablePublishDate())
                    .slug(item.getSlug())
                    .path(item.getPath())
                    .url(item.getUrl())
                    .commentsCount(item.getCommentsCount())
                    .publicReactionsCount(item.getPublicReactionsCount())
                    .collectionId(item.getCollectionId())
                    .publishedTimestamp(item.getPublishedTimestamp() != null ? Date.from(item.getPublishedTimestamp().toInstant()) : null)
                    .positiveReactionsCount(item.getPositiveReactionsCount())
                    .coverImage(item.getCoverImage())
                    .socialImage(item.getSocialImage())
                    .canonicalUrl(item.getCanonicalUrl())
                    .createdAt(item.getCreatedAt() != null ? Date.from(item.getCreatedAt().toInstant()) : null)
                    .editedAt(item.getEditedAt() != null ? Date.from(item.getEditedAt().toInstant()) : null)
                    .crosspostedAt(item.getCrosspostedAt() != null ? Date.from(item.getCrosspostedAt().toInstant()) : null)
                    .publishedAt(item.getPublishedAt() != null ? Date.from(item.getPublishedAt().toInstant()) : null)
                    .lastCommentAt(item.getLastCommentAt() != null ? Date.from(item.getLastCommentAt().toInstant()) : null)
                    .tagList(item.getTagList())
                    .tags(item.getTags())
                    .user(item.getUser())
                    .flareTag(item.getFlareTag())
                    .date(publishedAt.getYear() + "-" + String.format("%02d", publishedAt.getMonthValue()) + "-" + String.format("%02d", publishedAt.getDayOfMonth()))
                    .build();

            articles.add(article);
        }

        return articles;
    }
}
