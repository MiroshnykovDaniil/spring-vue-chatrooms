package com.donationalerts.youtubeparser.Controller;

import com.donationalerts.youtubeparser.entity.Message;
import com.donationalerts.youtubeparser.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;

@Slf4j
@RestController
public class MessageController {
    private MessageRepository repository;

    MessageController(MessageRepository repository){this.repository = repository;}

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable Long id){
        return repository.findById(id).orElseThrow(OBJECT_NOT_EXIST::new);
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message){
        return repository.save(message);
    }

    @DeleteMapping("message/{id}")
    public void deleteMessage(@PathVariable Long id){
        repository.deleteById(id);
    }

    @Transactional
    @PutMapping("/message/{id}")
    public void changeMessage(@RequestBody String text, @PathVariable Long id){
        log.error("before: "+ repository.findById(id));
        repository.setMessage(id, text);
        log.error("after: "+repository.findById(id));
        return;
    }
}