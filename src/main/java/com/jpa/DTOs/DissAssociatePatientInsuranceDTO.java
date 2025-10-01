package com.jpa.DTOs;


public class DissAssociatePatientInsuranceDTO {
    private String patientId ;
    private String insuranceId;

    public DissAssociatePatientInsuranceDTO() {
    }

    public DissAssociatePatientInsuranceDTO(String patientId, String insuranceId) {
        this.patientId = patientId;
        this.insuranceId = insuranceId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }


    @Override
    public String toString() {
        return "DissAssociatePatientInsurance{" +
                "patientId='" + patientId + '\'' +
                ", insuranceId='" + insuranceId + '\'' +
                '}';
    }
}

