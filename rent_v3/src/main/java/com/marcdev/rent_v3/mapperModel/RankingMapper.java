package com.marcdev.rent_v3.mapperModel;

import com.marcdev.rent_v3.model.Ranking;
import com.marcdev.rent_v3.modelDTO.RankingDto;

public class RankingMapper {

    public RankingDto toDto(Ranking ranking){
        return new RankingDto(
                ranking.getLikes(),
                ranking.getDislike()
        );
    }

    public Ranking toRanking(RankingDto rankingDto){
        return new Ranking(
                rankingDto.getLikes(),
                rankingDto.getDislike()
        );
    }
}
