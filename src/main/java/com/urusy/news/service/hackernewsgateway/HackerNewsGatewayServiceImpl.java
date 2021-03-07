package com.urusy.news.service.hackernewsgateway;

import com.urusy.news.code.StoriesType;
import com.urusy.news.dto.HackerNewsStoryResponseDto;
import com.urusy.news.entity.HackerNewsStoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HackerNewsGatewayServiceImpl implements HackerNewsGatewayService {

    public List<HackerNewsStoryEntity> getStories(StoriesType storiesType) {
        var stories = new ArrayList<HackerNewsStoryEntity>();

        int i = 0;
        for (var id : getIds(storiesType)) {
//            if (i > 20) break;
            i++;
            stories.add(getStoriesById(id));
        }

        return stories;
    }


    private Long[] getIds(StoriesType storiesType) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://hacker-news.firebaseio.com/v0/" + storiesType.getCode() + ".json";

        ResponseEntity<Long[]> ids = restTemplate.getForEntity(url, Long[].class);

        return ids.getBody();
    }

    private HackerNewsStoryEntity getStoriesById(long id) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://hacker-news.firebaseio.com/v0/item/" + id +".json";

        ResponseEntity<HackerNewsStoryResponseDto> news = restTemplate.getForEntity(url, HackerNewsStoryResponseDto.class);

        var body = news.getBody();
        var time = new Date(body.getTime() * 1000);
        var localDate = time.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return HackerNewsStoryEntity.builder()
                .id(body.getId())
                .deleted(body.isDeleted())
                .type(body.getType())
                .by(body.getBy())
                .time(time)
                .text(body.getText())
                .dead(body.isDead())
                .parent(body.getParent())
                .poll(body.getPoll())
                .kids(body.getKids())
                .url(body.getUrl())
                .score(body.getScore())
                .title(body.getTitle())
                .parts(body.getParts())
                .descendants(body.getDescendants())
                .date(localDate.getYear() + "-" + String.format("%02d", localDate.getMonthValue()) + "-" + String.format("%02d", localDate.getDayOfMonth())).build();
    }
}
