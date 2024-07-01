package com.maverickstube.services;


import com.maverickstube.dtos.requests.LikeMediaRequest;
import com.maverickstube.dtos.responses.LikeResponse;

public interface LikeServices {
    LikeResponse likeMedia(LikeMediaRequest request);
}
