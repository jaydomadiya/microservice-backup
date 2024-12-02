package com.ms2.ms_app2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App2Controller {
    @GetMapping(path = "/test2")
    public String app2Controller(){
        System.out.println("I am from test2");
        return "i am from test2";
    }
}
