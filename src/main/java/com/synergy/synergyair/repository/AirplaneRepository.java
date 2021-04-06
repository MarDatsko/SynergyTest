package com.synergy.synergyair.repository;

import com.synergy.synergyair.entity.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane,Long> {
}
