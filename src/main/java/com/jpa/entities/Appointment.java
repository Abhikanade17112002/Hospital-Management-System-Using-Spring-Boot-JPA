package com.jpa.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String appointmentId ;

    @Column( nullable = false )
    private LocalDateTime appointmentDateTime ;

    @Column( nullable = false , length = 500)
    private String description ;

    @ManyToOne
    @JoinColumn( nullable = false  , name = "patientId")
    private Patient patient ;

    @ManyToOne
    @JoinColumn( name = "doctorId" , nullable = false)
    private Doctor doctor ;

    public Appointment() {
    }

    public Appointment(String appointmentId, LocalDateTime appointmentDateTime, String description, Patient patient , Doctor doctor) {
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor ;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", description='" + description + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
