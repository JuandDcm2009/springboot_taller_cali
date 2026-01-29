package com.ponscio.taller.infrastructure.adapter.out.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class CountryEntity {
    @Id
    @Size(min = 1, max = 6)
    private String id;
    
    @Column
    @Size(min = 1, max = 6)
    @NotNull
    private String isocode;

    @Column
    @NotNull
    @Size(min = 1, max = 60)
    private String name;
}