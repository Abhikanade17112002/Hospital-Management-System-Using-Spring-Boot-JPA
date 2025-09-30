package com.jpa.controllers;
import com.jpa.entities.Insurance;
import com.jpa.entities.Patient;
import com.jpa.services.InsuranceService;
import com.jpa.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService ;
    @Autowired
    private InsuranceService insuranceService ;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient ){

        System.out.println("Patient Before Saving ==> " + patient);

        return patientService.addPatient( patient ) ;

    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable( name = "id") String patientId){

        System.out.println("Patient Id  ==> " + patientId);

        return patientService.getPatientById( patientId ) ;

    }

    @GetMapping
    public ResponseEntity getHomePage(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("<h1> Hello World </h1>") ;
    }

    @GetMapping("/name")
    public ResponseEntity getPatientByFullName(@RequestParam( name = "firstName") String firstName , @RequestParam(name = "lastName") String lastName ){

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        patientService.getPatientByFirstNameAndLastName( firstName , lastName )
                ) ;
    }

    @GetMapping("/bloodgroup/{bloodGroup}")
    public ResponseEntity<List<Patient>> getPatientsHavingBloodGroup( @PathVariable(name = "bloodGroup") String bloodGroup ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        patientService.getPatientsHavingBloodGroup( bloodGroup )
                ) ;
    }

    @GetMapping("/bloodgroupatientcount")
    public ResponseEntity<List<Object[]>> getPatientsHavingBloodGroup(  ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        patientService.getPatientCountPerBloodGroup( )
                ) ;
    }

    @PatchMapping("/assigninsurance/{id}")
    public ResponseEntity<Patient> assignInsuranceToThePatientWithId(@RequestBody Insurance insurance , @PathVariable( name = "id") String patientId){
        System.out.println("Hi");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                   patientService.assignInsuranceToThePatientWithId(     insurance , patientId  )
                ) ;
    }

}
