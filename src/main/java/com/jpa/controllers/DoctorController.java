package com.jpa.controllers;

import com.jpa.entities.Doctor;
import com.jpa.services.AppointmentService;
import com.jpa.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService ;
    @Autowired
    private AppointmentService appointmentService ;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        doctorService.getAllDoctors()
                ) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(name = "id") String doctorId ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        doctorService.getDoctorById( doctorId )
                ) ;
    }

    @PostMapping
    public ResponseEntity<Doctor> AddDoctor(@RequestBody Doctor doctor){
        System.out.println("1");
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        doctorService.addDoctor(doctor)
                ) ;
    }
}
