package com.maverickstube.services;

import com.maverickstube.maverickshub.dtos.requests.DislikeMediaRequest;
import com.maverickstube.maverickshub.dtos.responses.DislikeMediaResponse;
import com.maverickstube.maverickshub.models.Dislike;
import com.maverickstube.maverickshub.repositories.DislikeRepository;
import com.maverickstube.maverickshub.repositories.MediaRepository;
import com.maverickstube.maverickshub.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DislikeServicesImpl implements DislikeServices {
    private  final UserRepository userRepository;
    private final MediaRepository mediaRepository;
    private final DislikeRepository dislikeRepository;

    @Override
    public DislikeMediaResponse dislikeMedia(DislikeMediaRequest request) {
        Dislike dislike= new Dislike();
        if(!(userRepository.existsById(request.getUserId())
                ||mediaRepository.existsById(request.getMediaId())))throw  new RuntimeException("cant like media");
        dislike.setMediaId(request.getMediaId());
        dislike.setUserId(request.getUserId());
        dislikeRepository.save(dislike);
        var likes =dislikeRepository.findDislikesByMediaId(request.getMediaId());
        DislikeMediaResponse dislikeResponse = new DislikeMediaResponse();
        dislikeResponse.setNumberOfDislikes(likes.size());
        dislikeResponse.setMessage("liked successfully");
        return dislikeResponse;

    }


}
