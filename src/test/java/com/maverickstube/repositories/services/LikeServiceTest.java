package com.maverickstube.repositories.services;

import com.maverickstube.maverickshub.dtos.requests.LikeMediaRequest;
import com.maverickstube.maverickshub.dtos.responses.LikeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class LikeServiceTest {
    @Autowired
    private LikeServicesImpl likeService;

    @Test
    public void testThatUserCanLikeMedia(){
        LikeMediaRequest request = new LikeMediaRequest();
        request.setMediaId(102L);
        request.setUserId(200L);
        LikeResponse likeResponse= likeService.likeMedia(request);
       assertThat(likeResponse.getMessage()).isNotNull();
       assertThat(likeResponse.getNumberOfLikes()).isEqualTo(2);
    }
}
