package com.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "doctor")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "doctorId"
)
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
//    @JsonBackReference("doctor-appointments")
    private List<Appointment> appointmentList = new ArrayList<>() ;

    @OneToOne( mappedBy = "headDoctor")
//    @JsonBackReference("department-head-doctor")
    private Department isHeadOfDepartment ;

    @ManyToMany( mappedBy = "departmentDoctorsList")
//    @JsonBackReference("doctor-departments")
    private List<Department> belongsToDepartments = new ArrayList<>() ;

    public Doctor() {
    }

    public Doctor(String doctorId, String firstName, String lastName, String email, String education, List<Appointment> appointmentList, Department isHeadOfDepartment, List<Department> belongsToDepartments) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.education = education;
        this.appointmentList = appointmentList;
        this.isHeadOfDepartment = isHeadOfDepartment;
        this.belongsToDepartments = belongsToDepartments;
    }

    public Department getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(Department isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public List<Department> getBelongsToDepartments() {
        return belongsToDepartments;
    }

    public void setBelongsToDepartments(List<Department> brlongsToDepartments) {
        this.belongsToDepartments = brlongsToDepartments;
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
                ", belongsToDepartments=" + belongsToDepartments +
                '}';
    }
}
