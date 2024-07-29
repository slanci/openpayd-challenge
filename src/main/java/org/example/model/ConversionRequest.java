package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ConversionRequest {
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;

    public ConversionRequest(BigDecimal amount, String fromCurrency, String toCurrency) {
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionRequest that = (ConversionRequest) o;
        return Objects.equals(amount, that.amount) && Objects.equals(fromCurrency, that.fromCurrency) && Objects.equals(toCurrency, that.toCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, fromCurrency, toCurrency);
    }

    @Override
    public String toString() {
        return "ConversionRequest{" +
                "amount=" + amount +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                '}';
    }
}