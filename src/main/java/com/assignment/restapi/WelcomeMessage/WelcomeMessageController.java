package com.assignment.restapi.WelcomeMessage;

import org.springframework.web.bind.annotation.*;

//RestAPI
@RestController
public class WelcomeMessageController {
    //@RequestMapping(method = RequestMethod.GET,path="/welcome")
    @GetMapping(path = "/welcome")
    public String welcomeMessage(){
        return "Welcome to the Spring Boot!";
    }

    @GetMapping(path="/welcome/path/{name}")
    public String pathMessage(@PathVariable String name){
        return "Welcome to the Spring Boot!"+name;
    }

}
