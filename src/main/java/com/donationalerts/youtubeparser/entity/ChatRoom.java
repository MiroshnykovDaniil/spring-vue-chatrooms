package com.donationalerts.youtubeparser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "chatrooms")
public class ChatRoom {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<User> userList=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;

    @ManyToMany
    @JoinColumn(name="moderator_id", referencedColumnName = "id")
    private List<User> moderators;

    @OneToMany
    @JoinColumn(name="message_id",referencedColumnName="id")
    private List<Message> messages;
    private String name;

    ChatRoom(String name, User creator){
        this.name=name;
        userList = new ArrayList<>();
        moderators = new ArrayList<>();
        this.creator=creator;
        userList.add(creator);
        messages = new ArrayList<>();
    }

    public void addUser(User user){
        if (!userList.contains(user))
        userList.add(user);
    }
    public void deleteUser(User user){
        if(userList.contains(user))
            userList.add(user);
    }
}
