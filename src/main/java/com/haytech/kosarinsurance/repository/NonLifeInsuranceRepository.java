package com.haytech.kosarinsurance.repository;

import com.haytech.kosarinsurance.model.entity.NonlifeInsurance;
import com.haytech.kosarinsurance.model.entity.RetireOrgan;
import com.haytech.kosarinsurance.service.NonLifeInsuranceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NonLifeInsuranceRepository extends JpaRepository<NonlifeInsurance,Long> {
    Optional<NonlifeInsurance> findByIdAndIsDeletedFalse(Long id);
}
