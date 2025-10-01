package com.jpa.controllers;


import com.jpa.DTOs.AppointmentRequestDTO;
import com.jpa.entities.Appointment;
import com.jpa.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService ;


    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(

                        appointmentService.getAllAppointments()
                ) ;
    }


    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentRequestDTO appointment){
        System.out.println(appointment);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        appointmentService.addAppointment(
                                appointment
                        )
                ) ;


    }
}
