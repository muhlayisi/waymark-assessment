package com.waymark.assessment.repository;

import com.waymark.assessment.model.VerificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRecordsRepository extends JpaRepository<VerificationRecord, Long> {

}
