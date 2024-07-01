package com.maverickstube.services;


import com.maverickstube.dtos.requests.DislikeMediaRequest;
import com.maverickstube.dtos.responses.DislikeMediaResponse;

public interface DislikeServices {
    DislikeMediaResponse dislikeMedia(DislikeMediaRequest request);
}
