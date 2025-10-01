package com.jpa.services;


import com.jpa.DTOs.AssignDoctorToDepartmentDTO;
import com.jpa.DTOs.AssignHeadDoctorDTO;
import com.jpa.entities.Department;
import com.jpa.entities.Doctor;
import com.jpa.repositories.DepartmentRepository;
import com.jpa.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository ;

    @Autowired
    private DoctorRepository doctorRepository ;
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll() ;
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department) ;
    }

    public Department assignHeadDoctorToDepartment(AssignHeadDoctorDTO assignHeadDoctorDTO) {
        System.out.println();
        Doctor retrivedDoctor = doctorRepository.findById(assignHeadDoctorDTO.getDoctorId()).orElse(null) ;
        Department retrivedDepartment = departmentRepository.findById(
                assignHeadDoctorDTO.getDepartmentId()
        ).orElse(null) ;

        retrivedDepartment.setHeadDoctor(
                retrivedDoctor
        );
        retrivedDepartment.getDepartmentDoctorsList().add(retrivedDoctor);

        retrivedDoctor.setIsHeadOfDepartment(
                retrivedDepartment
        );
        retrivedDoctor.getBelongsToDepartments().add(
                retrivedDepartment
        );

        departmentRepository.save(retrivedDepartment) ;

        return retrivedDepartment ;
    }

    public Department addDoctorToDepartment(AssignDoctorToDepartmentDTO assignDoctorToDepartmentDTO) {

        Doctor retrivedDoctor = doctorRepository.findById(assignDoctorToDepartmentDTO.getDoctorId()).orElse(null);
        Department retrivedDepartment = departmentRepository.findById(assignDoctorToDepartmentDTO.getDepartmentId()).orElse(null) ;

        retrivedDepartment.getDepartmentDoctorsList().add(retrivedDoctor) ;
        retrivedDoctor.getBelongsToDepartments().add(retrivedDepartment) ;

        departmentRepository.save(retrivedDepartment) ;

        return retrivedDepartment ;
    }
}
