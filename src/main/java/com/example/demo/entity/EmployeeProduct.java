package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_product")
@Getter
@Setter
public class EmployeeProduct {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public EmployeeProduct() {}

    public Long getId() {
        return (id == null) ? null : id.longValue();
    }

    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
