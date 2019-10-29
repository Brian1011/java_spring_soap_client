package com.example.demo;

import hello.wsdl.GetAllUniversitiesResponse;
import hello.wsdl.GetUniversityResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(UniversityClient quoteClient){
        return args -> {
            String name = "Strathmore";

            if(args.length > 0 ){
                name = args[0];
            }

            GetUniversityResponse response = quoteClient.getUniversity(name);
            //System.err.println(response.getUniversity().getName());
            System.err.println(response.getUniversity().getName());
        };
    }

}
