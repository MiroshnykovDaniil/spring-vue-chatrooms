package com.donationalerts.youtubeparser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private User author;


    Message(String text, User author){this.author=author;this.text=text;}


}
