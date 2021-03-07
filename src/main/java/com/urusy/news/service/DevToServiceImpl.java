package com.urusy.news.service;

import com.urusy.news.entity.DevToArticleEntity;
import com.urusy.news.repository.DevToArticleRepository;
import com.urusy.news.service.devtogateway.DevToGatewayServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevToServiceImpl {

    final private DevToGatewayServiceImpl devToGatewayService;
    final private DevToArticleRepository devToArticleRepository;

    public List<DevToArticleEntity> getTopArticles(int limit) {
        var articles = devToGatewayService.getTopArticles(limit);

        for (var article : articles) {
            devToArticleRepository.save(article);
        }

        return articles;
    }
}
