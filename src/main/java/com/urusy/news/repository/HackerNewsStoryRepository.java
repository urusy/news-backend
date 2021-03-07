package com.urusy.news.repository;

import com.urusy.news.component.FirestoreConfig;
import com.urusy.news.entity.HackerNewsStoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class HackerNewsStoryRepository {

    private final FirestoreConfig firestoreConfig;

    public void save(HackerNewsStoryEntity story) {
        firestoreConfig.getDb().collection("hacker-news").document(String.valueOf(story.getId())).create(story);
    }
}
