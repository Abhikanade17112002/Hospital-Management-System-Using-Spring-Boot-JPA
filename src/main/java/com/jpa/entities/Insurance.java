package com.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurance")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "insuranceId"
)
public class Insurance {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String insuranceId ;

    @Column( nullable = false , unique = true , length = 50)
    private String policyNumber ;

    @Column( nullable = false , length = 150 )
    private String policyProvider ;

    @Column( nullable = false )
    private LocalDate validUntil ;

    @CreationTimestamp
    @Column( nullable = false , updatable = false )
    private LocalDateTime createdAt ;

     @OneToOne( mappedBy = "insurance")
//     @JsonBackReference
     private Patient patient ;

    public Insurance() {
    }

    public Insurance(String insuranceId, String policyNumber, String policyProvider, LocalDate validUntil, LocalDateTime createdAt, Patient patient) {
        this.insuranceId = insuranceId;
        this.policyNumber = policyNumber;
        this.policyProvider = policyProvider;
        this.validUntil = validUntil;
        this.createdAt = createdAt;
        this.patient = patient;
    }


    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyProvider() {
        return policyProvider;
    }

    public void setPolicyProvider(String policyProvider) {
        this.policyProvider = policyProvider;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId='" + insuranceId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyProvider='" + policyProvider + '\'' +
                ", validUntil=" + validUntil +
                ", createdAt=" + createdAt +
                ", patient=" + patient +
                '}';
    }
}
