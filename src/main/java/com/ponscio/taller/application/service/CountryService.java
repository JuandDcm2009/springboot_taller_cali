package com.ponscio.taller.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ponscio.taller.domain.model.Country;
import com.ponscio.taller.domain.port.CountryRepositoryPort;

@Service
public class CountryService {

    private final CountryRepositoryPort repository;

    public CountryService(CountryRepositoryPort repository) {
        this.repository = repository;
    }

    public List<Country> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Optional<Country> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public Country save(Country country) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Optional<Country> update(String id, Country country) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Optional<Country> deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
