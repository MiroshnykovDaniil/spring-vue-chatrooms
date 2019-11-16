package com.donationalerts.youtubeparser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class City{
    public City(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
}
