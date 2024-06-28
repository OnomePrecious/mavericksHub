package com.maverickstube.repositories;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
@Slf4j
class DislikeRepositoryTest {

    @Autowired
    private DislikeRepository dislikeRepository;
        @Test
        void findDisLikesById() {
            var dislike = dislikeRepository.findDislikesById(20L);
            assertThat(dislike).isNotEmpty();

        }

        @Test
        @Sql(scripts = {"/db/data.sql"})
        void findLikesByMediaId() {
            var dislikes = dislikeRepository.findDislikesByMediaId(100L);
            assertThat(dislikes).hasSize(2);

        }

        @Test
        void testThatDislikesWithWrongIdIsEmpty(){
            var like = dislikeRepository.findDislikesById(200L);
            assertThat(like).isEmpty();
        }

        @Test
        void testThatDislikesWithWrongMediaIdIsEmpty(){
            var like = dislikeRepository.findDislikesByMediaId(2070L);
            assertThat(like).isEmpty();
        }
    }