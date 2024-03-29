package com.example.demo;

import hello.wsdl.GetAllUniversitiesResponse;
import hello.wsdl.GetUniversityByLocationResponse;
import hello.wsdl.GetUniversityResponse;
import hello.wsdl.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(UniversityClient quoteClient){
        return args -> {
            // get university by name
            String name = "Strathmore";

            if(args.length > 0 ){
                name = args[0];
            }

            GetUniversityResponse response = quoteClient.getUniversity(name);
            System.err.println("############### BY NAME ##################");
            System.err.println("University Name: "+response.getUniversity().getName()
                    + " Location: "+response.getUniversity().getLocation()
                    + " Year Founded: "+response.getUniversity().getYearFounded()
            );

            // get university by location
            String location = "Juja";

            if (args.length > 0 ){
                location = args[0];
            }

            GetUniversityByLocationResponse response1 = quoteClient.getUniversityByLocationRequest(location);
            System.err.println("############### BY LOCATION ##################");
            System.err.println("University Name: "+response1.getUniversity().getName()
                    + " Location: "+response1.getUniversity().getLocation()
                    + " Year Founded: "+response1.getUniversity().getYearFounded()
            );

            // get all universities
            GetAllUniversitiesResponse response2 = quoteClient.getAllUniversitiesResponse();
            System.err.println("############### ALL UNIVERSITIES ##################");
            //System.err.println(response2.getUniversity());

            // get university as a list
            List<University> universitiesList = response2.getUniversity();

            int count = 0;
            for (University university: universitiesList){
                if(count == 3)
                    break;
                System.err.println("University Name: "+university.getName()
                        + " Location: "+university.getLocation()
                        + " Year Founded: "+university.getYearFounded()
                );
                count = count + 1;
            }
        };
    }

}
