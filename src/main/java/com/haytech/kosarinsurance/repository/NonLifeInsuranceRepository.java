package com.haytech.kosarinsurance.repository;

import com.haytech.kosarinsurance.model.entity.NonlifeInsurance;
import com.haytech.kosarinsurance.service.NonLifeInsuranceService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonLifeInsuranceRepository extends JpaRepository<NonlifeInsurance,Long> {
}
