package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.model.Ranking;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.RankingDto;
import com.marcdev.rent_v3.repository.ArticleRepository;
import com.marcdev.rent_v3.repository.RankingRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.RankingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankingService implements RankingServiceInterface {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RankingRepository rankingRepository;


    @Override
    public boolean createLikeAndDislike(Long userId ,Long articleId, RankingDto rankingDto) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Article> article = articleRepository.findById(articleId);
        if(user.isPresent() && article.isPresent()){
                var rank = Ranking.builder()
                        .dislike(rankingDto.getDislike())
                        .likes(rankingDto.getLikes())
                        .id(new Ranking.UserArticleKey(user.get().getId(), article.get().getId()))
                        .user(userRepository.getReferenceById(userId))
                        .article(articleRepository.getReferenceById(articleId))
                        .build();
                rankingRepository.save(rank);
            return  true;
            }
        return false;
    }

    @Override
    public String deleteLikeAndDislike(Long userId, Long articleId) {
        var user = userRepository.findById(userId);
        var article = articleRepository.findById(articleId);
        if (user.isPresent() && article.isPresent()){
            rankingRepository.deleteById(new Ranking.UserArticleKey(userId,articleId).getArticleId());
            return "success";
        }
        return "false";
    }

    @Override
    public List<Ranking> getRanking(Long id) {
        var article = articleRepository.findById(id);
        if (article.isPresent()){
            return rankingRepository.findAll();
        }
        return null;
    }

}
