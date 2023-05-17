package com.haytech.kosarinsurance.controller;

import com.haytech.kosarinsurance.model.entity.NonlifeInsurance;
import com.haytech.kosarinsurance.service.NonLifeInsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NonLifeInsuranceController {
    private final NonLifeInsuranceService nonLifeInsuranceService;

    public NonLifeInsuranceController(NonLifeInsuranceService nonLifeInsuranceService) {
        this.nonLifeInsuranceService = nonLifeInsuranceService;
    }


    @GetMapping(value = "/v1/nonLifeInsurances")
    public ResponseEntity<List<NonlifeInsurance>> getAllNonLifeInsurances() {
        List<NonlifeInsurance> nonlifeInsurances = nonLifeInsuranceService.getAllNonLifeInsurances();
        return new ResponseEntity<>(nonlifeInsurances, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/nonLifeInsurance")
    public ResponseEntity<NonlifeInsurance> getNonLifeInsuranceById(@RequestParam Long id) {
        Optional<NonlifeInsurance> nonlifeInsurance = nonLifeInsuranceService.getNonLifeInsuranceById(id);
        return nonlifeInsurance.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/v1/nonLifeInsurances")
    public ResponseEntity<NonlifeInsurance> createNonLifeInsurance(@RequestBody NonlifeInsurance nonlifeInsurance) {
        NonlifeInsurance createdLifeInsurance = nonLifeInsuranceService.createNonLifeInsurance(nonlifeInsurance);
        return new ResponseEntity<>(createdLifeInsurance, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/nonLifeInsurances")
    public ResponseEntity<NonlifeInsurance> updateNonLifeInsurance(@RequestParam Long id, @RequestBody NonlifeInsurance nonlifeInsurance) {
        Optional<NonlifeInsurance> nonLifeInsuranceById = nonLifeInsuranceService.getNonLifeInsuranceById(id);
        if (nonLifeInsuranceById.isPresent()) {
            nonlifeInsurance.setId(id);
            NonlifeInsurance updateNonLifeInsurance = nonLifeInsuranceService.updateNonLifeInsurance(nonlifeInsurance);
            return new ResponseEntity<>(updateNonLifeInsurance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/v1/nonLifeInsurances")
    public ResponseEntity<Void> deleteNonLifeInsurance(@RequestParam Long id) {
        Optional<NonlifeInsurance> existinNonlifeInsurance = nonLifeInsuranceService.getNonLifeInsuranceById(id);
        if (existinNonlifeInsurance.isPresent()) {
            nonLifeInsuranceService.deleteNonLifeInsurance(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/v1/uploadExcelDataNonLife")
    public String uploadNonLife(@RequestParam MultipartFile file,
                         @RequestParam Integer numberOfSheet)
            throws Exception {
        nonLifeInsuranceService.upload(file, numberOfSheet);
        return "ok";
    }
}
