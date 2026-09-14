package com.waymark.assessment.repository;

import com.waymark.assessment.model.VerificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<VerificationRecord, Long> {

}
