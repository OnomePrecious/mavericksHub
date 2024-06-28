package com.maverickstube.repositories;

import com.maverickstube.maverickshub.models.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DislikeRepository extends JpaRepository<Dislike, Long> {
    Optional<Dislike> findDislikesById(Long id);
    List<Dislike> findDislikesByMediaId(Long mediaId);
}
