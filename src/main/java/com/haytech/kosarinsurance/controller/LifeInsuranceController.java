package com.haytech.kosarinsurance.controller;

import com.haytech.kosarinsurance.model.entity.LifeInsurance;
import com.haytech.kosarinsurance.service.LifeInsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LifeInsuranceController {
    private final LifeInsuranceService lifeInsuranceService;

    public LifeInsuranceController(LifeInsuranceService lifeInsuranceService) {
        this.lifeInsuranceService = lifeInsuranceService;
    }

    @GetMapping(value = "/v1/LifeInsurances")
    public ResponseEntity<List<LifeInsurance>> getAllLifeInsurances() {
        List<LifeInsurance> lifeInsurances = lifeInsuranceService.getAllLifeInsurances();
        return new ResponseEntity<>(lifeInsurances, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/LifeInsurance")
    public ResponseEntity<LifeInsurance> getLifeInsuranceById(@RequestParam Long id) {
        Optional<LifeInsurance> lifeInsurance = lifeInsuranceService.getLifeInsuranceById(id);
        return lifeInsurance.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/v1/LifeInsurance")
    public ResponseEntity<LifeInsurance> createLifeInsurance(@RequestBody LifeInsurance lifeInsurance) {
        LifeInsurance createdLifeInsurance = lifeInsuranceService.createLifeInsurance(lifeInsurance);
        return new ResponseEntity<>(createdLifeInsurance, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/LifeInsurance")
    public ResponseEntity<LifeInsurance> updateLifeInsurance(@RequestParam Long id, @RequestBody LifeInsurance lifeInsurance) {
      Optional<LifeInsurance> updatedLifeInsurance = Optional.ofNullable(lifeInsuranceService.updateLifeInsurance(lifeInsurance));
        return updatedLifeInsurance.map(insurance -> new ResponseEntity<>(insurance, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/v1/LifeInsurance")
    public ResponseEntity<Void> deleteLifeInsurance(@RequestParam Long id) {
         lifeInsuranceService.getLifeInsuranceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/v1/uploadExcelDataLife")
    public ResponseEntity<String> uploadLife(@RequestParam MultipartFile file,
                         @RequestParam Integer numberOfSheet)
            throws Exception {
        lifeInsuranceService.upload(file, numberOfSheet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
