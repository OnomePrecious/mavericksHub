package com.maverickstube.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
@ToString
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String description;
    @Enumerated(value = STRING)
    private Category category;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timeCreated;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timeUpdated;
    @OneToMany
    private List<Like> likes = new ArrayList<>();
    @OneToMany
   private List<Dislike> dislikes = new ArrayList<>();
    @ManyToOne
    private User uploader;
    @PrePersist
    private void setTimeCreated() {
        this.timeCreated = now();
    }

    @PreUpdate
    private void setTimeUpdated() {
        this.timeUpdated = now();
    }
    @Transient
    private int numberOfLikes(){
        return likes.size();
    }
    @Transient
    private int numberOfDislikes(){
        return dislikes.size();
    }

}
