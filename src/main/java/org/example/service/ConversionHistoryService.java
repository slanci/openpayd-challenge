package org.example.service;

import org.example.model.ConversionRecord;
import org.example.repository.ConversionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConversionHistoryService {

    @Autowired
    private ConversionRecordRepository conversionRecordRepository;

    public Page<ConversionRecord> getConversionHistory(String transactionId, LocalDate date, Pageable pageable) {
        if (transactionId != null && !transactionId.isEmpty()) {
            return conversionRecordRepository.findByTransactionId(transactionId, pageable);
        } else if (date != null) {
            return conversionRecordRepository.findByDate(date, pageable);
        } else {
            return conversionRecordRepository.findAll(pageable);
        }
    }
}
