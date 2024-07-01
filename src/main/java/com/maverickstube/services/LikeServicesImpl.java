package com.maverickstube.services;

import com.maverickstube.dtos.requests.LikeMediaRequest;
import com.maverickstube.dtos.responses.LikeResponse;
import com.maverickstube.models.Like;
import com.maverickstube.repositories.LikeRepository;
import com.maverickstube.repositories.MediaRepository;
import com.maverickstube.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class LikeServicesImpl implements LikeServices{
   private  final UserRepository userRepository;
   private final MediaRepository mediaRepository;
   private final LikeRepository repository;
    @Override
    public LikeResponse likeMedia(LikeMediaRequest request) {
        Like like= new Like();
        if(!(userRepository.existsById(request.getUserId())
                ||mediaRepository.existsById(request.getMediaId())))throw  new RuntimeException("cant like media");
        like.setMediaId(request.getMediaId());
        like.setUserid(request.getUserId());
        repository.save(like);
        var likes =repository.findLikesByMediaId(request.getMediaId());
        LikeResponse likeResponse = new LikeResponse();
        likeResponse.setNumberOfLikes(likes.size());
        likeResponse.setMessage("liked successfully");
        return likeResponse;
    }
}
