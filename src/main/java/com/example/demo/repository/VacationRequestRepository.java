package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {

    List<VacationRequest> findByEmployee(Employee employee);
}
