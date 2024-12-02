package com.ms1.ms_app1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class App1Controller {
    @GetMapping(path = "/test1")
    public String app1Controller(){
        System.out.println("I am from test1");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9098/test2", String.class);
        String body = forEntity.getBody();
        return "Success from api  === > " + body;
    }
}
