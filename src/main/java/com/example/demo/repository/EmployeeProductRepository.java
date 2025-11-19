package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeProduct;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeProductRepository extends JpaRepository<EmployeeProduct, Long> {

    List<EmployeeProduct> findByEmployee(Employee employee);

    List<EmployeeProduct> findByProduct(Product product);
}
