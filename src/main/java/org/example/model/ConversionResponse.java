package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ConversionResponse {
    private BigDecimal convertedAmount;
    private String transactionId;

    public ConversionResponse(BigDecimal convertedAmount, String transactionId) {
        this.convertedAmount = convertedAmount;
        this.transactionId = transactionId;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionResponse that = (ConversionResponse) o;
        return Objects.equals(convertedAmount, that.convertedAmount) && Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertedAmount, transactionId);
    }

    @Override
    public String toString() {
        return "ConversionResponse{" +
                "convertedAmount=" + convertedAmount +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}