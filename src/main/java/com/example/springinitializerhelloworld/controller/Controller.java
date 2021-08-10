package com.example.springinitializerhelloworld.controller;

import com.example.springinitializerhelloworld.model.Greeting;
import com.example.springinitializerhelloworld.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        logger.info("Entered into hello() method");
        return new ResponseEntity<>("Hello! My name is Eiman.", HttpStatus.OK);
    }

    @GetMapping("/greeting")
    public ResponseEntity<List<Greeting>> getGreeting(@RequestParam(value = "name", required = false) String name) {
        logger.info("Entered into getGreeting() method");
        List<Greeting> greetingList = greetingService.getGreetings(name);
        return new ResponseEntity<>(greetingList, HttpStatus.OK);
    }

    @GetMapping("/sum")
    public ResponseEntity<Integer> getSum(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        logger.info("Entered into getSum() method");
        int sum = greetingService.sum2Nums(a, b);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
}
