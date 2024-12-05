package com.zys.elec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

        @RequestMapping("/sayHello")
        public String sayHello() {
            return "Hello Spring Boot!";
        }

}
