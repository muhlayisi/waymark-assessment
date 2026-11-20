package com.waymark.assessment.controller;

import com.waymark.assessment.model.VerificationRecord;
import com.waymark.assessment.service.VerificationRecordsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/verifications")
public class VerificationRecordsController {

    private final VerificationRecordsService verificationRecordsService;

    @GetMapping
    public ResponseEntity<List<VerificationRecord>> getAllVerificationRecords() {
        return ResponseEntity.ok(verificationRecordsService.getAllVerificationRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VerificationRecord>> getVerificationRecordById(@PathVariable long id) {
        Optional<VerificationRecord> verificationRecord = verificationRecordsService.getVerificationRecordById(id);

        if (verificationRecord.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(verificationRecordsService.getVerificationRecordById(id));
    }

}
