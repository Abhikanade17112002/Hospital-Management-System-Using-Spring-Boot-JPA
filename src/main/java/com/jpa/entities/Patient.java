package com.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jpa.types.BloodGroup;
import com.jpa.types.Gender;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "patient")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "patientId"
)
public class Patient {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String patientId ;

    @Column( nullable = false )
    private String firstName ;

    @Column( nullable = false )
    private String lastName ;

    @Column( nullable = false )
    private LocalDate birthDate ;

    @Enumerated( EnumType.STRING)
    @Column( nullable = false )
    private BloodGroup bloodGroup ;

    @Column( nullable = false , unique = true )
    private String email ;

    @Column( nullable = false  )
    @Enumerated( EnumType.STRING)
    private Gender gender ;

    @CreationTimestamp
    @Column( nullable = false , updatable = false )
    private LocalDateTime createdAt ;

//    @JsonManagedReference
    @OneToOne( cascade = { CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REMOVE} , orphanRemoval = true)
    @JoinColumn( name = "insuranceId")
    private Insurance insurance ;

//    @JsonManagedReference
    @OneToMany( mappedBy = "patient" , cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST} , orphanRemoval = true)
    private List<Appointment> appointmentList = new ArrayList<>() ;

    public Patient() {

    }

    public Patient(String patientId, String firstName, String lastName, LocalDate birthDate, BloodGroup bloodGroup, String email, Gender gender , LocalDateTime createdAt , Insurance insurance , List<Appointment> appointmentList) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.gender = gender;
        this.createdAt = createdAt ;
        this.insurance = insurance ;
        this.appointmentList = appointmentList ;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", bloodGroup=" + bloodGroup +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", createdAt=" + createdAt +
                ", insurance=" + insurance +
                ", appointmentList=" + appointmentList +
                '}';
    }
}
