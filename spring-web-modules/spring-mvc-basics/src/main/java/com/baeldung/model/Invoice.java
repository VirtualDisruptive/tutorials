package com.baeldung.model;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invoice {

    private long id;

    @NotBlank(message = "{concepto.notblank}")
    private String concept;

    @Positive(message = "{amount.positive}")
    private double amount;


    @Positive(message = "{retentionPercentage.positive}")
    @Max(value = 100, message = "{retentionPercentage.max}")
    private double retentionPercentage;


    public Invoice() {
    }
    public Invoice(long id, String concept, double amount, double retentionPercentage) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.retentionPercentage = retentionPercentage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRetentionPercentage() {
        return retentionPercentage;
    }

    public void setRetentionPercentage(double retentionPercentage) {
        this.retentionPercentage = retentionPercentage;
    }
}
