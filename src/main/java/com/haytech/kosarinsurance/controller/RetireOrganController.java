package com.haytech.kosarinsurance.controller;

import com.haytech.kosarinsurance.model.entity.RetireOrgan;
import com.haytech.kosarinsurance.service.RetireOrganService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RetireOrganController {
    private final RetireOrganService retireOrganService;

    public RetireOrganController(RetireOrganService retireOrganService) {
        this.retireOrganService = retireOrganService;
    }


    @GetMapping(value = "/v1/retireOrgans")
    public ResponseEntity<List<RetireOrgan>> getAllRetireOrgans() {
        List<RetireOrgan> retireOrgans = retireOrganService.getAllRetireOrgans();
        return new ResponseEntity<>(retireOrgans, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/retireOrgan")
    public ResponseEntity<RetireOrgan> getRetireOrganById(@RequestParam Long id) {
        Optional<RetireOrgan> retireOrgan = retireOrganService.getRetireOrganById(id);
        return retireOrgan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/v1/retireOrgan")
    public ResponseEntity<RetireOrgan> createRetireOrgan(@RequestBody RetireOrgan retireOrgan) {
        RetireOrgan retireOrgan1 = retireOrganService.createRetireOrgan(retireOrgan);
        return new ResponseEntity<>(retireOrgan1, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/retireOrgan")
    public ResponseEntity<RetireOrgan> updateRetireOrgan(@RequestParam Long id, @RequestBody RetireOrgan retireOrgan) {


        Optional<RetireOrgan> retireOrganExist = Optional.ofNullable(retireOrganService.updateRetireOrgan(retireOrgan));
        return retireOrganExist.map(insurance -> new ResponseEntity<>(insurance, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/v1/retireOrgan")
    public ResponseEntity<Void> deleteRetireOrgan(@RequestParam Long id) {
        retireOrganService.deleteRetireOrgan(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/v1/uploadExcelDataRetireOrgan")
    public ResponseEntity<String> uploadRetireOrgan(@RequestParam MultipartFile file,
                                                @RequestParam Integer numberOfSheet)
            throws Exception {
        retireOrganService.upload(file, numberOfSheet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/v1/exportExcelDataRetireOrgan")
    public ResponseEntity<String> exportRetireOrgan()
            throws Exception {
        retireOrganService.exportToExcel();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
