package com.maverickstube.services;

import com.github.fge.jsonpatch.JsonPatch;
import com.maverickstube.dtos.requests.UploadMediaRequest;
import com.maverickstube.dtos.responses.MediaResponse;
import com.maverickstube.dtos.responses.UpdateMediaResponse;
import com.maverickstube.dtos.responses.UploadMediaResponse;
import com.maverickstube.exceptions.UserNotFoundException;
import com.maverickstube.models.Media;

import java.util.List;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest request);

    Media getMediaBy(Long id);

    UpdateMediaResponse updateMedia(Long mediaId, JsonPatch updateMediaRequest);

    List<MediaResponse> getMediaFor(Long userId) throws UserNotFoundException;
}
