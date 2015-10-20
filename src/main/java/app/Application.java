package app;

import app.models.AnsRecord;
import app.models.ChoiceQuestion;
import app.repositories.AnsRecordRepository;
import app.repositories.ChoiceQuestionRepository;
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
    public CommandLineRunner demo(ChoiceQuestionRepository repository,AnsRecordRepository arepository) {
        return (args) -> {
            // save a couple of
//            repository.save(new User("aaa","bbbb","cccc","dddd","eeee",1));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (ChoiceQuestion question : repository.findAll()) {
//                log.info(question.toString()+"\n");
                System.out.println(question.toString());
            }

            for(AnsRecord ans:arepository.findAll()){
                System.out.println(ans.toString());
            }

            log.info("");
            // fetch an individual customer by ID
            ChoiceQuestion question = repository.findOne(1L);
            log.info(question.toString());

        };
    }

}