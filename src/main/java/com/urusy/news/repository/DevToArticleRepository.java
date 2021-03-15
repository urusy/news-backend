package com.urusy.news.repository;

import com.urusy.news.component.FirestoreConfig;
import com.urusy.news.entity.DevToArticleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DevToArticleRepository {

    private final FirestoreConfig firestoreConfig;

    public void save(DevToArticleEntity article) {
        firestoreConfig.getDb().collection("dev-to").document(String.valueOf(article.getId())).set(article);
    }
}
