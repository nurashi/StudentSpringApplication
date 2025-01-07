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
            Student nurassyl = new Student(
                    "Nurassyl",
                    LocalDate.of(2007, 7, 25),
                    "nur778@gmail.com"
            );

            Student abzal = new Student(
                    "Abzal",
                    LocalDate.of(2003, 12, 8),
                    "Abzy@gmail.com"
            );
            repository.saveAll(
                    List.of(nurassyl, abzal)
            );
        };
    }
}
