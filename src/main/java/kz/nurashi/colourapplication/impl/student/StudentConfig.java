package kz.nurashi.colourapplication.impl.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandlineRunner(StudentRepository repository) {
        return args -> {
            repository.saveAll(
                    List.of()
            );
        };
    }
}
