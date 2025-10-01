package com.jpa.DTOs;

public class DissassociateAppointmentRequestDTO {
    private String patientId ;
    private String appointmentId ;

    public DissassociateAppointmentRequestDTO() {
    }

    public DissassociateAppointmentRequestDTO(String patientId, String appointmentId) {
        this.patientId = patientId;
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public String toString() {
        return "DissassociateAppointmentRequestDTO{" +
                "patientId='" + patientId + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                '}';
    }
}
