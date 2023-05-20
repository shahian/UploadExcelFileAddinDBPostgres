package com.haytech.kosarinsurance.repository;

import com.haytech.kosarinsurance.model.entity.LifeInsurance;
import com.haytech.kosarinsurance.model.entity.NonlifeInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LifeInsuranceRepository extends JpaRepository<LifeInsurance,Long> {

    Optional<LifeInsurance> findByIdAndIsDeletedFalse(Long id);

}
