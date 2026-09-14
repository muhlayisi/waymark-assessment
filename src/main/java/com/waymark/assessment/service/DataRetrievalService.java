package com.waymark.assessment.service;

import com.waymark.assessment.model.VerificationRecord;
import com.waymark.assessment.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataRetrievalService {

    private DataRepository dataRepository;

    private VerificationRecord verificationRecord;

    public Optional<VerificationRecord> getVerificationRecord(long id){
        return dataRepository.findById(id);
    }

    public List<VerificationRecord> getAllVerificationRecord(){
        return dataRepository.findAll();
    }
}
