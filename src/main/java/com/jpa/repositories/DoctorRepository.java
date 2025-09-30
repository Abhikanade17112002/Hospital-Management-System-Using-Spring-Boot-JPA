package com.jpa.repositories;

import com.jpa.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
}
