package com.jotadev.socialmediamongo.service;

import com.jotadev.socialmediamongo.domain.Post;
import com.jotadev.socialmediamongo.repository.PostRepository;
import com.jotadev.socialmediamongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        // por a data ser gerada com o hoário de 00:00:00, vamos adicionar mais um dia noo maxDate
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
