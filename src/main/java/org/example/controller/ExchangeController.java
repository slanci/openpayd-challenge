package org.example.controller;


import org.example.model.ConversionRecord;
import org.example.model.ConversionRequest;
import org.example.model.ConversionResponse;
import org.example.model.ExchangeRateResponse;
import org.example.service.ConversionHistoryService;
import org.example.service.CurrencyConversionService;
import org.example.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")

public class ExchangeController {

        @Autowired
        private ExchangeService exchangeService;

        @Autowired
        private CurrencyConversionService currencyConversionService;

        @Autowired
        private ConversionHistoryService conversionHistoryService;

        @GetMapping("/exchange-rate")
        public ResponseEntity<ExchangeRateResponse> getExchangeRate(
                @RequestParam String from,
                @RequestParam String to) {
            ExchangeRateResponse exchangeRate = exchangeRateService.getExchangeRate(from, to);
            return ResponseEntity.ok(exchangeRate);
        }

        @PostMapping("/convert")
        public ResponseEntity<ConversionResponse> convertCurrency(@RequestBody ConversionRequest request) {
            ConversionResponse conversion = currencyConversionService.convertCurrency(request);
            return ResponseEntity.ok(conversion);
        }

        @GetMapping("/history")
        public ResponseEntity<Page<ConversionRecord>> getConversionHistory(
                @RequestParam(required = false) String transactionId,
                @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                Pageable pageable) {
            Page<ConversionRecord> conversionHistory = conversionHistoryService.getConversionHistory(transactionId, date, pageable);
            return ResponseEntity.ok(conversionHistory);
        }
}
