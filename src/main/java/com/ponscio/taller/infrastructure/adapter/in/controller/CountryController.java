package com.ponscio.taller.infrastructure.adapter.in.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ponscio.taller.application.service.CountryService;
import com.ponscio.taller.domain.model.Country;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CountryController {
    
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Country country, BindingResult result) {
        if (result.hasFieldErrors()) return validation(result);
        return ResponseEntity.ok(service.save(country));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@Valid @RequestBody Country country, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        return service.update(id, country).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Country> optionalCountry = service.deleteById(id);
        if (optionalCountry.isPresent()) return ResponseEntity.ok(optionalCountry.orElseThrow());
        return ResponseEntity.notFound().build();
    }


    public ResponseEntity<?> validation(BindingResult result) {
        Map<String ,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
    

}
