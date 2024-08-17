package com.jotadev.workshopmongo.config;

import com.jotadev.workshopmongo.domain.Post;
import com.jotadev.workshopmongo.domain.User;
import com.jotadev.workshopmongo.repository.PostRepository;
import com.jotadev.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

// CommandLineRunner -> interface do Spring Boot usada para executar quando a aplicação for iniciada
@Configuration
public class instantiate implements CommandLineRunner {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("GMT"));

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    // método run() é executado assim que a aplicação for iniciada
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, (LocalDate) LocalDate.parse("21/03/2024", dtf), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, (LocalDate) LocalDate.parse("23/03/2024", dtf), "Bom dia", "Acordei feliz hoje!", alex);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
