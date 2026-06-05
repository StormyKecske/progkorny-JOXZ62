package hu.progkorny;

import hu.progkorny.model.Student;
import hu.progkorny.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgkornyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgkornyApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(StudentRepository repo) {
        return args -> {
            repo.save(new Student("Teszt Elek"));
            repo.save(new Student("Kiss Béla"));
            repo.save(new Student("Nagy Anna"));
        };
    }
}
