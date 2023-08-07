package com.marcdev.rent_v3.repository;

import com.marcdev.rent_v3.model.Ranking;
import com.marcdev.rent_v3.modelDTO.RankingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {
    Optional<RankingDto> findByLikes(Long id);

    Optional<RankingDto> findByDislike(Long id);
}
