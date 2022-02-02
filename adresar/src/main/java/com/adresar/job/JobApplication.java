package com.adresar.job;

import com.adresar.job.model.User;
import com.adresar.job.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JobApplication {



    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =
        SpringApplication.run(JobApplication.class, args);

        UserRepository userRepository =
        configurableApplicationContext.getBean(UserRepository.class);

        User user1 = new User("Tomislav", "Karnas", "Radnička 21", LocalDate.parse("1994-12-02"), "tomislav.karnas@gmail.com", "0977369847");
        User user2 = new User("Marko", "Marić", "Ilica 21", LocalDate.parse("1992-05-12"), "markec@gmail.com", "0917369847");
        User user3 = new User("Ana", "Ankica", "Selska ulica 121", LocalDate.parse("2000-12-02"), "ankica@gmail.com", "0927369847");

        if(userRepository.findAll().isEmpty()){
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        }
    }

}
