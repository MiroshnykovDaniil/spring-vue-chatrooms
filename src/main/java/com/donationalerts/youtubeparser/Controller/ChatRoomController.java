package com.donationalerts.youtubeparser.Controller;

import com.donationalerts.youtubeparser.entity.ChatRoom;
import com.donationalerts.youtubeparser.entity.User;
import com.donationalerts.youtubeparser.repository.ChatRoomRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
public class ChatRoomController {

    private ChatRoomRepository repository;

    ChatRoomController(ChatRoomRepository roomRepository){this.repository=roomRepository;}

    @PostMapping("/chatroom")
    public ChatRoom addChatRoom(@RequestBody ChatRoom chatRoom){
        return repository.save(chatRoom);
    }
    @GetMapping("/chatroom/{id}")
    public ChatRoom getChatRoom(@PathVariable Long id){
        return repository.findById(id).orElseThrow(OBJECT_NOT_EXIST::new);
    }
    @Transactional
    @PutMapping("/chatroom/adduser")
    public ChatRoom addUser(@RequestBody ObjectNode objectNode) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ChatRoom chatRoom = objectMapper.treeToValue(objectNode.get("chatroom"),ChatRoom.class);
        User user = objectMapper.treeToValue(objectNode.get("user"),User.class);
        chatRoom.addUser(user);
        log.error("user:" +user.getId() +";chatroom:"+chatRoom.getUserList());
        List<User> userList = chatRoom.getUserList();
        log.error(userList.toString());
        repository.addUsertoRoom(chatRoom.getId(),userList);
        return chatRoom;
    }
}
