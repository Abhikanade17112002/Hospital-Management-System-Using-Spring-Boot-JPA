package com.jpa.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "department")
public class Department {

    @Id
    @GeneratedValue ( strategy =  GenerationType.UUID )
    private String departmentId ;

    @Column( nullable = false , unique = true , length = 100 )
    private String departmentName ;

    @OneToOne
    @JoinColumn( nullable = false , name = "headDoctorId")
    private Doctor headDoctor ;

    @ManyToMany
    @JoinTable(
            name = "departmentdoctormapping" ,
            joinColumns = @JoinColumn( name = "departmentId") ,
            inverseJoinColumns = @JoinColumn( name = "doctorId")
    )
    private List<Doctor> departmentDoctorsList = new ArrayList<>() ;

    public Department() {
    }

    public Department(String departmentId, String departmentName, Doctor headDoctor, List<Doctor> departmentDoctorsList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctor = headDoctor;
        this.departmentDoctorsList = departmentDoctorsList;
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Doctor getHeadDoctor() {
        return headDoctor;
    }

    public void setHeadDoctor(Doctor headDoctor) {
        this.headDoctor = headDoctor;
    }

    public List<Doctor> getDepartmentDoctorsList() {
        return departmentDoctorsList;
    }

    public void setDepartmentDoctorsList(List<Doctor> departmentDoctorsList) {
        this.departmentDoctorsList = departmentDoctorsList;
    }


    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", headDoctor=" + headDoctor +
                ", departmentDoctorsList=" + departmentDoctorsList +
                '}';
    }
}
