package com.sid.gl.domain.port.outgoing;


import com.sid.gl.domain.model.Employee;

import java.util.List;

public interface EmployeeRepositoryPort {
Employee saveEmployee(Employee employee);
List<Employee> findAll();
}
