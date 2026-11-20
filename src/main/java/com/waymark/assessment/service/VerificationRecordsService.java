package com.waymark.assessment.service;

import com.waymark.assessment.model.VerificationRecord;
import com.waymark.assessment.repository.VerificationRecordsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationRecordsService {

    private VerificationRecordsRepository verificationRecordsRepository;

    public List<VerificationRecord> getAllVerificationRecords() {
        List<VerificationRecord> verificationRecords = verificationRecordsRepository.findAll();
        return verificationRecords;
    }

    public Optional<VerificationRecord> getVerificationRecordById(long id) {
        return verificationRecordsRepository.findById(id);
    }

    public void saveAllVerificationRecords(List<VerificationRecord> verificationRecordList) {
        verificationRecordsRepository.saveAll(verificationRecordList);
    }
}
