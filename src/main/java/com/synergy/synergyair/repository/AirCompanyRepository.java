package com.synergy.synergyair.repository;

import com.synergy.synergyair.entity.AirCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends CrudRepository<AirCompany,Long> {
}
