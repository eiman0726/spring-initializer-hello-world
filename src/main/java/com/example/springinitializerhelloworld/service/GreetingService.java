package com.example.springinitializerhelloworld.service;

import com.example.springinitializerhelloworld.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public List<Greeting> getGreetings(String name) {
        List<Greeting> greetingList = new ArrayList<>();
        greetingList.add(new Greeting(counter.incrementAndGet(), String.format(template, "Momin")));
        greetingList.add(new Greeting(counter.incrementAndGet(), String.format(template, "Eiman")));
        greetingList.add(new Greeting(counter.incrementAndGet(), String.format(template, "Wali")));

        if (name != null) {
            greetingList = greetingList
                    .stream()
                    .filter(e -> e.getContent().contains(name))
                    .map(e -> new Greeting(e.getId(), e.getContent().toUpperCase()))
                    .collect(Collectors.toList());
        }
        return greetingList;
    }

    public int sum2Nums(int a, int b) {
        return a + b;
    }
}
