package com.jpa.services;


import com.jpa.DTOs.AppointmentRequestDTO;
import com.jpa.entities.Appointment;
import com.jpa.entities.Doctor;
import com.jpa.entities.Patient;
import com.jpa.repositories.AppointmentRepository;
import com.jpa.repositories.DoctorRepository;
import com.jpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository ;

    @Autowired
    private PatientRepository patientRepository ;

    @Autowired
    private DoctorRepository doctorRepository ;

    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll() ;
    }


    public Appointment addAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        Patient retrivedPatient = patientRepository.findById(appointmentRequestDTO.getPatientId()).orElse(null) ;
        Doctor retrivedDoctor = doctorRepository.findById(appointmentRequestDTO.getDoctorId()).orElse(null) ;

        if( retrivedDoctor == null || retrivedPatient == null ){
            System.out.println("Either Of The Two Is Null");
        }
        Appointment appointment = new Appointment() ;
        appointment.setPatient(retrivedPatient);
        appointment.setDoctor(retrivedDoctor);
        appointment.setAppointmentDateTime(appointmentRequestDTO.getAppointmentDateTime());
        appointment.setDescription(appointmentRequestDTO.getDescription());



        retrivedDoctor.getAppointmentList().add(appointment) ;
        retrivedPatient.getAppointmentList().add(appointment) ;

        return appointmentRepository.save(appointment) ;
    }
}
