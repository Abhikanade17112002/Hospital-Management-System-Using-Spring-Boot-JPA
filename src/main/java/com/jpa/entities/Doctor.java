package com.jpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String doctorId ;

    @Column( nullable = false)
    private String firstName ;

    @Column( nullable = false )
    private String lastName ;

    @Column( nullable = false , unique = true , length = 100)
    private String email ;

    @Column( nullable = false , length = 100)
    private String education ;

    @OneToMany( mappedBy = "doctor")
    private List<Appointment> appointmentList = new ArrayList<>() ;

    @OneToOne( mappedBy = "headDoctor")
    private Department isHeadOfDepartment ;

    @ManyToMany( mappedBy = "departmentDoctorsList")
    private List<Department> brlongsToDepartments = new ArrayList<>() ;

    public Doctor() {
    }

    public Doctor(String doctorId, String firstName, String lastName, String email, String education, List<Appointment> appointmentList, Department isHeadOfDepartment, List<Department> brlongsToDepartments) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.education = education;
        this.appointmentList = appointmentList;
        this.isHeadOfDepartment = isHeadOfDepartment;
        this.brlongsToDepartments = brlongsToDepartments;
    }

    public Department getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(Department isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public List<Department> getBrlongsToDepartments() {
        return brlongsToDepartments;
    }

    public void setBrlongsToDepartments(List<Department> brlongsToDepartments) {
        this.brlongsToDepartments = brlongsToDepartments;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", appointmentList=" + appointmentList +
                ", isHeadOfDepartment=" + isHeadOfDepartment +
                ", brlongsToDepartments=" + brlongsToDepartments +
                '}';
    }
}
