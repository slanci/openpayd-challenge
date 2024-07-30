package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ConversionRecord {
    @Id
    private String transactionId;
    private LocalDate date;
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal convertedAmount;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionRecord that = (ConversionRecord) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(date, that.date) && Objects.equals(amount, that.amount) && Objects.equals(fromCurrency, that.fromCurrency) && Objects.equals(toCurrency, that.toCurrency) && Objects.equals(convertedAmount, that.convertedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, date, amount, fromCurrency, toCurrency, convertedAmount);
    }

    @Override
    public String toString() {
        return "ConversionRecord{" +
                "transactionId='" + transactionId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", convertedAmount=" + convertedAmount +
                '}';
    }
}
