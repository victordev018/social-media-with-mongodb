package com.jotadev.workshopmongo.repository;

import com.jotadev.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    // Query para realizar a busca de posts que o título contém o text que foi dado
    // o regex ?0 refere-se ao primeiro parâmetro, text, vindo como argumento do método
    // a options faz o papel do IgnoreCase na busca

    @Query(" { 'title' : { $regex : ?0, $options : 'i'}} ")
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
