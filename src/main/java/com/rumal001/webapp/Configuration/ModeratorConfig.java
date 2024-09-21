package com.rumal001.webapp.Configuration;


import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Repositories.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ModeratorConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunner(ModeratorRepository moderatorRepository) {
        return args -> {
            Moderator moderator = new Moderator(
                    "Pachax",
                    "Shermon",
                    "pachax001@gmail.com",
                    "0769014596",
                    passwordEncoder.encode("password123"),
                    "www.google.com"
            );
            moderatorRepository.save(moderator);
        };
    }
}
