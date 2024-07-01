package com.maverickstube.controllers;

import com.maverickstube.dtos.requests.UploadMediaRequest;
import com.maverickstube.dtos.responses.UploadMediaResponse;
import com.maverickstube.exceptions.UserNotFoundException;
import com.maverickstube.services.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UploadMediaResponse> uploadMedia(@ModelAttribute UploadMediaRequest uploadMediaRequest){
        return ResponseEntity.status(CREATED)
                .body(mediaService.upload(uploadMediaRequest));
    }


    @GetMapping
    public ResponseEntity<?> getMediaForUser(@RequestParam Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(mediaService.getMediaFor(userId));
    }

}
