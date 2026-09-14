package com.waymark.assessment.controller;

import com.waymark.assessment.model.VerificationRecord;
import com.waymark.assessment.service.DataRetrievalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/verifications")
public class DataController {

    private final DataRetrievalService dataRetrievalService;

    public DataController(DataRetrievalService dataRetrievalService) {
        this.dataRetrievalService = dataRetrievalService;
    }

    @GetMapping
    public ResponseEntity<List<VerificationRecord>> getAllRecords(){
        return ResponseEntity.ok(dataRetrievalService.getAllVerificationRecord());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VerificationRecord>> geRecordById(@PathVariable long id){
        return ResponseEntity.ok(dataRetrievalService.getVerificationRecord(id));
    }

}
