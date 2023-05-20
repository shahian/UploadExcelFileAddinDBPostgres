package com.haytech.kosarinsurance.controller;

import com.haytech.kosarinsurance.model.entity.ApiAddRequest;
import com.haytech.kosarinsurance.service.EndpointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiScanerController {
    private final EndpointService endpointService;

    public ApiScanerController(EndpointService endpointService) {
        this.endpointService = endpointService;
    }
    @GetMapping(value = "/v1/Apis" )
    public ResponseEntity<?> getAllApi() {

        List<ApiAddRequest> apiAddRequests= endpointService.getEndpoints();
        return new ResponseEntity<>(apiAddRequests, HttpStatus.OK);
    }
    @GetMapping(value = "/v1/getEndpoints" )
    public ResponseEntity<?> getEndpoints() {

        List<ApiAddRequest> apiAddRequests= endpointService.getEndpoints1();
        return new ResponseEntity<>(apiAddRequests, HttpStatus.OK);
    }
}
