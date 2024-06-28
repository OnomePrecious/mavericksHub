package com.maverickstube.repositories.services;

import com.maverickstube.maverickshub.dtos.requests.DislikeMediaRequest;
import com.maverickstube.maverickshub.dtos.responses.DislikeMediaResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

    @SpringBootTest
    @Sql(scripts = {"/db/data.sql"})
    public class DislikeServiceTest {
        @Autowired
        private DislikeServicesImpl dislikeService;

        @Test
        public void testThatUserCanLikeMedia() {
            DislikeMediaRequest request = new DislikeMediaRequest();
            request.setMediaId(102L);
            request.setUserId(200L);
            DislikeMediaResponse dislikeMediaResponse = dislikeService.dislikeMedia(request);
            assertThat(dislikeMediaResponse.getMessage()).isNotNull();
            assertThat(dislikeMediaResponse.getNumberOfDislikes()).isEqualTo(2);

        }
    }
