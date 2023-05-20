package com.haytech.kosarinsurance.service;

import com.haytech.kosarinsurance.model.entity.RetireOrgan;
import com.haytech.kosarinsurance.repository.RetireOrganRepository;
import com.haytech.kosarinsurance.tools.RetireOrganExcelReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RetireOrganService {
    private final RetireOrganRepository retireOrganRepository;

    public RetireOrganService(RetireOrganRepository retireOrganRepository) {
        this.retireOrganRepository = retireOrganRepository;
    }

    public List<RetireOrgan> getAllRetireOrgans() {
        return retireOrganRepository.findAll();
    }

    public Optional<RetireOrgan> getRetireOrganById(Long id) {
        return retireOrganRepository.findById(id);
    }

    public RetireOrgan createRetireOrgan(RetireOrgan retireOrgan) {
        return retireOrganRepository.save(retireOrgan);
    }

    public RetireOrgan updateRetireOrgan(RetireOrgan retireOrgan) {
        Optional<RetireOrgan> retireOrganExist = retireOrganRepository.findByIdAndIsDeletedFalse(retireOrgan.getId());
        if (retireOrganExist.isPresent()) {
            return retireOrganRepository.save(retireOrgan);
        } else {
            return null;
        }

    }

    public void deleteRetireOrgan(Long id) {
        Optional<RetireOrgan> retireOrganById = retireOrganRepository.findByIdAndIsDeletedFalse(id);
        if (retireOrganById.isPresent()) {
            retireOrganById.get().setIsDeleted(false);
            retireOrganRepository.save(retireOrganById.get());
        }

    }


    public void upload(MultipartFile file, Integer numberOfSheet) throws IOException {
        RetireOrganExcelReader retireOrganExcelReader = new RetireOrganExcelReader();
        List<RetireOrgan> retireOrgans = retireOrganExcelReader.readExcelFile(file, numberOfSheet);
        retireOrganRepository.saveAll(retireOrgans);
    }
}
