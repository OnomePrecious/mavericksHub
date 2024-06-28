package com.maverickstube.services;

import com.maverickstube.maverickshub.dtos.requests.LikeMediaRequest;
import com.maverickstube.maverickshub.dtos.responses.LikeResponse;

public interface LikeServices {
    LikeResponse likeMedia(LikeMediaRequest request);
}
