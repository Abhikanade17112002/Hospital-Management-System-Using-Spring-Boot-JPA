package com.jpa.repositories;
import com.jpa.entities.Patient;
import com.jpa.types.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {


    Patient findByFirstNameAndLastName(String patientName, String lastName);
    @Query("SELECT P FROM Patient P WHERE P.bloodGroup =:bloodGroup")
    List<Patient> getPatientsHavingBloodGroup(@Param("bloodGroup") BloodGroup bloodGroupEnum);

    @Query("SELECT P.bloodGroup, COUNT(P.patientId) FROM Patient P GROUP BY P.bloodGroup")
    List<Object[]> getPatientCountPerBloodGroup();

}
