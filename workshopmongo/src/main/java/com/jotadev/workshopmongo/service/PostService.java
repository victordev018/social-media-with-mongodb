package com.jotadev.workshopmongo.service;

import com.jotadev.workshopmongo.domain.Post;
import com.jotadev.workshopmongo.repository.PostRepository;
import com.jotadev.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        if (post.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }
        return post.get();
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }
}
