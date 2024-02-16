package com.apart.ge.apartments.controller;

import com.apart.ge.apartments.model.Greeting;
import com.apart.ge.apartments.service.ApartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ApartmentController {

    private final ApartmentService apartmentService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/")
    public String get() {
        apartmentService.service();
        return null;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
