package com.maverickstube.repositories;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;



@Slf4j
@SpringBootTest
class LikeRepositoryTest {
   @Autowired
    private LikeRepository likeRepository;
    @Test
    void findLikesById() {
       var like = likeRepository.findLikesById(20L);
        assertThat(like).isNotEmpty();

    }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    void findLikesByMediaId() {
        var like = likeRepository.findLikesByMediaId(100L);
        assertThat(like).hasSize(2);
    }

    @Test
    void testThatLikesWithWrongIdIsEmpty(){
        var like = likeRepository.findLikesById(200L);
        assertThat(like).isEmpty();
    }

    @Test
    void testThatLikesWithWrongMediaIdIsEmpty(){
        var like = likeRepository.findLikesByMediaId(2070L);
        assertThat(like).isEmpty();
    }
}