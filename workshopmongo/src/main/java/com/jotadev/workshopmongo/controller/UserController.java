package com.jotadev.workshopmongo.controller;

import com.jotadev.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria Brown", "maria@gmail.com");
        User joao = new User("2", "joao Blue", "joao@gmail.com");
        List<User> list = Arrays.asList(maria, joao);
        return ResponseEntity.ok().body(list);
    }
}
