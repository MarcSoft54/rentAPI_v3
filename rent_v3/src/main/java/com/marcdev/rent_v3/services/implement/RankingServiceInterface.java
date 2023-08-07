package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.modelDTO.RankingDto;

public interface RankingServiceInterface{

    boolean createLikeAndDislike(Long id, RankingDto rankingDto);

    String deleteLikeAndDislike(Long id);

    Long getLike(Long id);

    Long getDislike(Long id);
}
