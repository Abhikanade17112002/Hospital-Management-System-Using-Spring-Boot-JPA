package com.jpa.services;

import com.jpa.entities.Doctor;
import com.jpa.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository ;
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll() ;
    }

    public Doctor addDoctor( Doctor doctor) {
        System.out.println("2");
        return doctorRepository.save(doctor) ;
    }

    public Doctor getDoctorById(String doctorId) {

        return  doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("Doctor With Id " + doctorId + " Not Found")) ;

    }
}
