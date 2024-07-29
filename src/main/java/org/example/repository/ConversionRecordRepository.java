package org.example.repository;

import org.example.model.ConversionRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ConversionRecordRepository extends JpaRepository<ConversionRecord, String> {

    Page<ConversionRecord> findByTransactionId(String transactionId, Pageable pageable);

    Page<ConversionRecord> findByDate(LocalDate date, Pageable pageable);
}
