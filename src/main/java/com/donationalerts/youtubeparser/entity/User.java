package com.donationalerts.youtubeparser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JsonIgnore
    private String password;
}
