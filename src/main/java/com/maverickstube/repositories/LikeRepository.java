package com.maverickstube.repositories;

import com.maverickstube.maverickshub.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findLikesById(Long id);
    List<Like> findLikesByMediaId(Long mediaId);

}
