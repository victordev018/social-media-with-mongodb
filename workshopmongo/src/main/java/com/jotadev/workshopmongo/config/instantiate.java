package com.jotadev.workshopmongo.config;

import com.jotadev.workshopmongo.domain.User;
import com.jotadev.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// CommandLineRunner -> interface do Spring Boot usada para executar quando a aplicação for iniciada
@Configuration
public class instantiate implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    // método run() é executado assim que a aplicação for iniciada
    @Override
    public void run(String... args) throws Exception {

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.deleteAll();
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
