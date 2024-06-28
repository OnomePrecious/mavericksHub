package com.maverickstube.services;

import com.maverickstube.maverickshub.dtos.requests.DislikeMediaRequest;
import com.maverickstube.maverickshub.dtos.responses.DislikeMediaResponse;

public interface DislikeServices {
    DislikeMediaResponse dislikeMedia(DislikeMediaRequest request);
}
