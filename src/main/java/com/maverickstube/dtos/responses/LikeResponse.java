package com.maverickstube.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikeResponse {
    private int numberOfLikes;
    private String message;
}
