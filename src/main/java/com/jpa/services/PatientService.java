package com.jpa.services;

import com.jpa.DTOs.DissAssociatePatientInsuranceDTO;
import com.jpa.DTOs.DissassociateAppointmentRequestDTO;
import com.jpa.entities.Appointment;
import com.jpa.entities.Insurance;
import com.jpa.entities.Patient;
import com.jpa.repositories.PatientRepository;
import com.jpa.types.BloodGroup;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository ;

    public Patient addPatient(Patient patient) {

        return patientRepository.save(patient) ;
    }

    public Patient getPatientById(String patientId) {
        Patient p1 =  patientRepository.findById(patientId).orElseThrow(
                ()-> new IllegalArgumentException("No Patient With Id " + patientId)
        ) ;
        return p1 ;
    }

    public Patient getPatientByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName( firstName , lastName ) ;
    }

    public List<Patient> getPatientsHavingBloodGroup(String bloodGroup) {
        BloodGroup bloodGroupEnum = BloodGroup.valueOf(bloodGroup) ;
        return  patientRepository.getPatientsHavingBloodGroup( bloodGroupEnum ) ;

    }

    public List<Object[]> getPatientCountPerBloodGroup() {

        return  patientRepository.getPatientCountPerBloodGroup( ) ;
    }

    public Patient assignInsuranceToThePatientWithId(Insurance insurance, String patientId) {
        Patient retrivedPatient = null ;

        retrivedPatient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient With Id " + patientId + " Not Found")) ;


        if( retrivedPatient != null ){

            retrivedPatient.setInsurance(insurance);

            insurance.setPatient(retrivedPatient);

            patientRepository.save(retrivedPatient);
        }

        return  retrivedPatient ;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll() ;
    }

    public Patient dissassociatePatientWithAppointment(DissassociateAppointmentRequestDTO dto) {
        Patient retrivedPatient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Find the appointment to remove
        retrivedPatient.getAppointmentList()
                .removeIf(appt -> appt.getAppointmentId().equals(dto.getAppointmentId()));


        return patientRepository.save(retrivedPatient);
    }

    public Patient dissassociatePatientWithInsurance(DissAssociatePatientInsuranceDTO dto) {
        Patient retrivedPatient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Find the appointment to remove
        retrivedPatient.setInsurance(null);

        return patientRepository.save(retrivedPatient);
    }
}
