package org.example.service;

import org.example.model.ExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {

    @Value("${exchange.rate.api.url}")
    private String apiUrl;

    @Value("${exchange.rate.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public ExchangeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExchangeResponse getExchangeRate(String from, String to) {
        String url = String.format("%s?access_key=%s&symbols=%s,%s", apiUrl, apiKey, from, to);
        ExchangeResponse response = restTemplate.getForObject(url, ExchangeResponse.class);
        if (response != null) {
            response.setFromCurrency(from);
            response.setToCurrency(to);
        }
        return response;
    }
}