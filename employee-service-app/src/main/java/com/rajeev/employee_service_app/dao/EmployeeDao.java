package com.rajeev.employee_service_app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajeev.employee_service_app.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}