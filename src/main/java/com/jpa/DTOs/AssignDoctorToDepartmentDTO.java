package com.jpa.DTOs;

public class AssignDoctorToDepartmentDTO {

    private String departmentId ;
    private String doctorId ;

    public AssignDoctorToDepartmentDTO() {
    }

    public AssignDoctorToDepartmentDTO(String departmentId, String doctorId) {
        this.departmentId = departmentId;
        this.doctorId = doctorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "AssignDoctorToDepartmentDTO{" +
                "departmentId='" + departmentId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                '}';
    }
}
