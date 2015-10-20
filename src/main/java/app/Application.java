package app;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;


/**
 * Created by cjl20 on 2015/10/19.
 */

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of
//            repository.save(new User("aaa","bbbb","cccc","dddd","eeee",1));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");
            // fetch an individual customer by ID
            User user = repository.findOne(1L);
            log.info(user.toString());

        };
    }

}