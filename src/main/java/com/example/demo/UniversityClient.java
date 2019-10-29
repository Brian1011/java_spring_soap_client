package com.example.demo;

import hello.wsdl.GetUniversityRequest;
import hello.wsdl.GetUniversityResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UniversityClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UniversityClient.class);

    public GetUniversityResponse getUniversity(String name){
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        log.info("Requesting name for "+name);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7991/ws/universities", request,
                            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest")
                        );

        return response;
    }
}
