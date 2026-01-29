package com.ponscio.taller.infrastructure.adapter.out.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ponscio.taller.domain.model.Country;
import com.ponscio.taller.domain.port.CountryRepositoryPort;
import com.ponscio.taller.infrastructure.adapter.out.entity.CountryEntity;
import com.ponscio.taller.infrastructure.adapter.out.repository.JPACountryRepository;
@Repository
public class CountryRepositoryImpl implements CountryRepositoryPort{

    private final JPACountryRepository repository;

    public CountryRepositoryImpl(JPACountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Country> getById(String id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public Country save(Country country) {
        CountryEntity entity = toEntity(country);
        CountryEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Country> update(String id, Country country) {
        return repository.findById(id).map(entity -> {
            entity.setId(entity.getId());
            entity.setIsocode(country.getIsocode());
            entity.setName(country.getName());
            return toDomain(repository.save(entity));
        });
    }

    @Override
    public Optional<Country> deleteById(String id) {
        return repository.findById(id).map( entity -> {
            repository.deleteById(id);
            return toDomain(entity);
        });
    }
    
    public Country toDomain(CountryEntity countryEntity) {
        return new Country(countryEntity.getId(), countryEntity.getIsocode(), countryEntity.getName());
    } 

    public CountryEntity toEntity(Country country) {
        return new CountryEntity(country.getId(), country.getIsocode(), country.getName());
    }


}
