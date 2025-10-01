package com.jpa.DTOs;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class AppointmentRequestDTO {
    private LocalDateTime appointmentDateTime;
    private String description;
    private String patientId;
    private String doctorId;

    // getters & setters

    public AppointmentRequestDTO() {
    }

    public AppointmentRequestDTO(LocalDateTime appointmentDateTime, String description, String patientId, String doctorId) {
        this.appointmentDateTime = appointmentDateTime;
        this.description = description;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "AppointmentRequestDTO{" +
                "appointmentDateTime=" + appointmentDateTime +
                ", description='" + description + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                '}';
    }
}