package com.jpa.controllers;

import com.jpa.DTOs.AssignDoctorToDepartmentDTO;
import com.jpa.DTOs.AssignHeadDoctorDTO;
import com.jpa.entities.Department;
import com.jpa.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService ;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(
                departmentService.getAllDepartments()
        ) ;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        departmentService.addDepartment(
                                department
                        )
                ) ;
    }

    @PatchMapping("/addheaddoctor")
    public ResponseEntity<Department> assignHeadDoctorToDepartmentToDepartment(@RequestBody AssignHeadDoctorDTO assignHeadDoctorDTO){

        System.out.println(assignHeadDoctorDTO);

        return ResponseEntity.status(HttpStatus.OK).body(
                departmentService.assignHeadDoctorToDepartment(assignHeadDoctorDTO)
        ) ;

    }
    @PostMapping("/adddepartmentdoctor")
    public ResponseEntity<Department> addDoctorToDepartment(@RequestBody AssignDoctorToDepartmentDTO assignDoctorToDepartmentDTO){
        return ResponseEntity.status(
                HttpStatus.OK
        )
                .body(
                        departmentService.addDoctorToDepartment( assignDoctorToDepartmentDTO)
                ) ;
    }


}
