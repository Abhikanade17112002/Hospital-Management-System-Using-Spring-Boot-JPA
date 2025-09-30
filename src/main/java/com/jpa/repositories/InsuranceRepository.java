package com.jpa.repositories;

import com.jpa.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance ,String> {
}
