package com.jpa.DTOs;

public class AssignHeadDoctorDTO {
    private String departmentId ;
    private String doctorId ;

    public AssignHeadDoctorDTO() {
    }

    public AssignHeadDoctorDTO(String departmentId, String doctorId) {
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
        return "AssignHeadDoctorDTO{" +
                "departmentId='" + departmentId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                '}';
    }
}
