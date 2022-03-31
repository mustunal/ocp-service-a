package com.mustunal.servicea;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class ApiController {


    @Value("${service-b-url}")
    private String serviceBUrl;
    @Value("${service-b-port}")
    private String serviceBPort;

    @GetMapping
    public String sayHello(){

        String requestUrl = "http://"+serviceBUrl+":"+serviceBPort+"/api/v1";

        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(requestUrl, String.class);
        return "Hello World! And " + forObject;
    }
}
