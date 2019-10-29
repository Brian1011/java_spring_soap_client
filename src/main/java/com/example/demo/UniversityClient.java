package com.example.demo;

import hello.wsdl.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UniversityClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UniversityClient.class);

    // get university by name
    public GetUniversityResponse getUniversity(String name){
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        log.info("Requesting univerity by name - "+name);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7991/ws/universities", request,
                            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest")
                        );

        return response;
    }

    // get university by location
    public GetUniversityByLocationResponse getUniversityByLocationRequest(String location){
        GetUniversityByLocationRequest request = new GetUniversityByLocationRequest();
        request.setLocation(location);

        log.info("Requesting University based on location - "+location);

        GetUniversityByLocationResponse response = (GetUniversityByLocationResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7991/ws/universities", request,
                            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest")
                        );
        return response;
    }

    // get all universities
    public GetAllUniversitiesResponse getAllUniversitiesResponse(){
        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();

        log.info("Requesting all universities");

        GetAllUniversitiesResponse response = (GetAllUniversitiesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7991/ws/universities", request,
                            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest")
                        );
        return response;
    }
}
