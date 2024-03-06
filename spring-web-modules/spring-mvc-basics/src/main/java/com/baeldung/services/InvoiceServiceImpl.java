package com.baeldung.services;


import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceTaxService{
    @Override
    public double calculateFinalAmount(double amount, double retentionPercentage) {
        double retentionAmount =  amount * (retentionPercentage / 100.0);
        return amount - retentionAmount;
    }
}
