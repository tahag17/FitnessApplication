package com.jetbrains.FitnessApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessApplication {

    private static final Logger log = LoggerFactory.getLogger(FitnessApplication.class);
    public static void main(String[] args) {SpringApplication.run(FitnessApplication.class, args);}

//    @Bean
//    CommandLineRunner runner(RunRepository runRepository){
//        return args -> {
//            Run run = new Run(1,
//                    "Another run",
//                    LocalDateTime.now(),
//                    LocalDateTime.now().plus(1, ChronoUnit.MINUTES),
//                    Location.Indoor,
//                    4);
//            runRepository.create(run);
//        };
//    }

}
