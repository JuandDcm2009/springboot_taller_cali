package com.ponscio.taller.domain.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ponscio.taller.domain.model.Country;

public interface CountryRepositoryPort {
    public List<Country> findAll();
    public Optional<Country> getById(String id);
    public Country save(Country country);
    public Optional<Country> update(String id, Country country);
    public Optional<Country> deleteById(String id);
}
