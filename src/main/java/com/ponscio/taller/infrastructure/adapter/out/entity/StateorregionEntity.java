package com.ponscio.taller.infrastructure.adapter.out.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stateorregions")
public class StateorregionEntity {
    @Id
    @Size(min = 1, max = 6)
    private String id;
    @NotNull
    @Size(min = 1, max = 60)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    @Size(min = 1, max = 6)
    private CountryEntity countryId;
    
    @Column(unique = true)
    @Size(min = 1, max = 2)
    private String code;
}
