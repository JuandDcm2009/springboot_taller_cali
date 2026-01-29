package com.ponscio.taller.infrastructure.adapter.out.impl;

import java.util.List;
import java.util.Optional;

import com.ponscio.taller.domain.model.Stateorregion;
import com.ponscio.taller.domain.port.StateorregionsRepositoryPort;
import com.ponscio.taller.infrastructure.adapter.out.entity.StateorregionEntity;

public class StateorregionRepositoryImpl implements StateorregionsRepositoryPort {

    @Override
    public List<Stateorregion> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Stateorregion> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Stateorregion save(Stateorregion stateorregion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Stateorregion> update(String id, Stateorregion stateorregion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<Stateorregion> deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    public Stateorregion toDomain(StateorregionEntity entity) {
        return new Stateorregion(entity.getId(), entity.getName(), entity.getCountryId().getId(), entity.getCode());
    }

}
