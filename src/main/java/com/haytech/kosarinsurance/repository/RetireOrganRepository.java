package com.haytech.kosarinsurance.repository;

import com.haytech.kosarinsurance.model.entity.RetireOrgan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetireOrganRepository extends JpaRepository<RetireOrgan, Long> {
    Optional<RetireOrgan> findByIdAndIsDeletedFalse(Long id);
}
