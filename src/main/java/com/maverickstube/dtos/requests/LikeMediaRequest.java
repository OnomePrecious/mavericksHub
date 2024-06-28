package com.maverickstube.dtos.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
@Setter
public class LikeMediaRequest {
    private Long mediaId;
    private Long userId;
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeLiked;

    @PrePersist
    public void setTimeLiked(){
        this.timeLiked=now();
    }

}
