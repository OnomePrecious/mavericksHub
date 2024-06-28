package com.maverickstube.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;


    @Getter
    @Setter
    @Entity
    @Table(name = "dislikes")
    public class Dislike {
        @Id

        @GeneratedValue
        private Long id;
        private Long mediaId;
        private Long userId;
        @JsonSerialize(using= LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @Setter(AccessLevel.NONE)
        private LocalDateTime timeDisliked;

        @PrePersist
        public void setTimeDisliked(){
            this.timeDisliked=now();
        }
}