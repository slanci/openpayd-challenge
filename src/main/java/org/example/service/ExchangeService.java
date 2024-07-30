package org.example.service;

import org.example.exception.ExchangeNotFoundException;
import org.example.model.ExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

@Service
public class ExchangeService {

    private static final Logger logger = Logger.getLogger(ExchangeService.class.getName());


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
        logger.info("URL: " + url);
        ExchangeResponse response = restTemplate.getForObject(url, ExchangeResponse.class);
        logger.info("API Response: " + response);
        try {
            if (response != null) {
                response.setFromCurrency(from);
                response.setToCurrency(to);
                response.setRate(response.getRates().get(to));
                return response;
            } else {
                throw new ExchangeNotFoundException("Exchange rate not found for " + from + " to " + to);
            }
        } catch (RestClientException e) {
            throw new ExchangeNotFoundException("Failed to fetch exchange rate for " + from + " to " + to);
        }
    }
}