package com.ponscio.taller.infrastructure.adapter.out.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ponscio.taller.infrastructure.adapter.out.entity.CountryEntity;

public interface JPACountryRepository extends JpaRepository<CountryEntity, String> {}
