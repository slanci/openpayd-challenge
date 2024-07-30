package org.example.service;

import org.example.exception.ConversionException;
import org.example.model.ConversionRequest;
import org.example.model.ConversionResponse;
import org.example.model.ConversionRecord;
import org.example.model.ExchangeResponse;
import org.example.repository.ConversionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class CurrencyConversionService {

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private ConversionRecordRepository conversionRecordRepository;

    public ConversionResponse convertCurrency(ConversionRequest request) {
        try {
            ExchangeResponse exchangeRateResponse = exchangeService.getExchangeRate(request.getFromCurrency(), request.getToCurrency());
            BigDecimal exchangeRate = exchangeRateResponse.getRate();
            BigDecimal convertedAmount = request.getAmount().multiply(exchangeRate);

            String transactionId = UUID.randomUUID().toString();

            ConversionRecord record = new ConversionRecord();
            record.setTransactionId(transactionId);
            record.setDate(LocalDate.now());
            record.setAmount(request.getAmount());
            record.setFromCurrency(request.getFromCurrency());
            record.setToCurrency(request.getToCurrency());
            record.setConvertedAmount(convertedAmount);

            conversionRecordRepository.save(record);

            return new ConversionResponse(convertedAmount, transactionId);
        }  catch (Exception e) {
            throw new ConversionException("Failed to convert currency from " + request.getFromCurrency() + " to " + request.getToCurrency());
        }

    }
}