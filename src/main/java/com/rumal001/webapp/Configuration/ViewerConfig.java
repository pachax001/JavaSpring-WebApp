package com.rumal001.webapp.Configuration;

import com.rumal001.webapp.Models.Viewer;
import com.rumal001.webapp.Repositories.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class ViewerConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner viewerCommandLineRunner(ViewerRepository repository) {
        return args -> {
            Viewer viewer = new Viewer(
                    "Rumal",
                    "Gunawardana",
                    "rumalg123@gmail.com",
                    "078920959",
                    passwordEncoder.encode("password123"),
                    "www.google.com",
                    LocalDateTime.now()

            );
            repository.save(viewer);
        };
    }
}
