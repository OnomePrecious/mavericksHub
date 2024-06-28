package com.maverickstube.dtos.requests;

import com.maverickstube.maverickshub.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMediaRequest {
    private String description;
    private Category category;
}
