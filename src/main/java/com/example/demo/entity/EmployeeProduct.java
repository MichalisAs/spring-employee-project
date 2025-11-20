package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_product")
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
