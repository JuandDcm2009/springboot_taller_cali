package com.ponscio.taller.domain.port;

import java.util.List;
import java.util.Optional;

import com.ponscio.taller.domain.model.Stateorregion;

public interface StateorregionsRepositoryPort {
    public List<Stateorregion> getAll();
    public Optional<Stateorregion> getById(String id);
    public Stateorregion save(Stateorregion stateorregions);
    public Optional<Stateorregion> update(String id, Stateorregion stateorregions);
    public Optional<Stateorregion> deleteById(String id);
}
