package com.haytech.kosarinsurance.repository;

import com.haytech.kosarinsurance.model.entity.LifeInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeInsuranceRepository extends JpaRepository<LifeInsurance,Long> {
}
