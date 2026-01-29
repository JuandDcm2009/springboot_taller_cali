package com.ponscio.taller.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ponscio.taller.application.exceptions.EntityNotFoundException;
import com.ponscio.taller.domain.model.Country;
import com.ponscio.taller.domain.port.CountryRepositoryPort;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    private final CountryRepositoryPort repository;

    public CountryService(CountryRepositoryPort repository) {
        this.repository = repository;
    }


    public List<Country> findAll() {
        return (List<Country>) repository.findAll().stream().toList();
    }

    public Country getById(String id) {
        return repository.getById(id).orElseThrow(() -> new EntityNotFoundException("The Object could not be found"));
    }

    @Transactional
    public Country save(Country country) {
        return repository.save(country);
    }

    public Optional<Country> update(String id, Country country) {
        return repository.update(id, country);
    }

    public Optional<Country> deleteById(String id) {
        return repository.deleteById(id);
    }
    
}
