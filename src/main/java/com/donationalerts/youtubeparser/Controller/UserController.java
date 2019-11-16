package com.donationalerts.youtubeparser.Controller;

import com.donationalerts.youtubeparser.entity.User;
import com.donationalerts.youtubeparser.exception.UserNotFoundException;
import com.donationalerts.youtubeparser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        return repository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PostMapping("user/add")
    public User addUser(@RequestBody User user){
        return repository.save(user);
    }

    @DeleteMapping("user/delete/{id}")
    public void deleteUser(@PathVariable long id){
        repository.deleteById(id);
    }
}
