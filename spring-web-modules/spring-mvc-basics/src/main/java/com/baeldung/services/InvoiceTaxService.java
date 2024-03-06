package com.baeldung.services;

public interface InvoiceTaxService {

    double calculateFinalAmount(double amount, double retentionPercentage);
}
