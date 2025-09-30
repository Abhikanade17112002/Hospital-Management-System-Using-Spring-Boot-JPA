package com.jpa.repositories;

import com.jpa.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {

}
