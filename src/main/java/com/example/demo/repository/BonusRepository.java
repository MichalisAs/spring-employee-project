package com.example.demo.repository;

import com.example.demo.entity.Bonus;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BonusRepository extends JpaRepository<Bonus, Long> {

    List<Bonus> findByCompany(Company company);

    List<Bonus> findByEmployee(Employee employee);
}
