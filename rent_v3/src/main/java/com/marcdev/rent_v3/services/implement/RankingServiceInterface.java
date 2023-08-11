package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Ranking;
import com.marcdev.rent_v3.modelDTO.RankingDto;

import java.util.List;
import java.util.Optional;

public interface RankingServiceInterface{

    boolean createLikeAndDislike(Long userId ,Long articleId, RankingDto rankingDto);

    String deleteLikeAndDislike(Long userId, Long articleId);

    List<Ranking> getRanking(Long id);

}
