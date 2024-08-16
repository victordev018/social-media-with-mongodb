package com.jotadev.workshopmongo.service;

import com.jotadev.workshopmongo.domain.User;
import com.jotadev.workshopmongo.repository.UserRepository;
import com.jotadev.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // dependencies
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }
        return user.get();
    }
}
