package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.modelDTO.RankingDto;

import java.util.Optional;

public interface RankingServiceInterface{

    boolean createLikeAndDislike(Long id, RankingDto rankingDto);

    String deleteLikeAndDislike(Long id);

    Optional<RankingDto> getRanking(Long id);

}
