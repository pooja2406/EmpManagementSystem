package com.progg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progg.entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
