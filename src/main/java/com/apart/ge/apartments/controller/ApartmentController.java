package com.apart.ge.apartments.controller;

import com.apart.ge.apartments.model.Greeting;
import com.apart.ge.apartments.model.Property;
import com.apart.ge.apartments.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping(path = "properties", produces = "application/json")
@RestController
@CrossOrigin(origins = "localhost:8080")
public class ApartmentController {

    private final ApartmentService apartmentService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping(path = "apartment/{id}", produces = "application/json")
    public Property getApartment(@PathVariable("id") Integer id) {
        return apartmentService.getApartment(id);
    }

    @GetMapping("/")
    public String get() {
        return "Hi";
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Property> getById(@PathVariable("id") Integer id) {
        Property apartment = apartmentService.getApartment(id);
        if (apartment != null) {
            return ResponseEntity.ok(apartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property createdProperty = apartmentService.createProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProperty);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Property patchProperty(@PathVariable("id") Integer id, @RequestBody Property property) {
        Property existingProperty = apartmentService.getApartment(id);
        if (existingProperty.getName() != null) {
            existingProperty.setName(property.getName());
        }
        if (existingProperty.getAddress() != null) {
            existingProperty.setAddress(property.getAddress());
        }
        apartmentService.save(existingProperty);
        return apartmentService.createProperty(existingProperty);
    }
}
