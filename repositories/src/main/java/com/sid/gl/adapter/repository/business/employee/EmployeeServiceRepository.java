package com.sid.gl.adapter.repository.business.employee;

import com.sid.gl.domain.model.Employee;
import com.sid.gl.domain.port.outgoing.EmployeeRepositoryPort;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceRepository implements EmployeeRepositoryPort {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.validate();
        return EmployeeMapper.mapToEmployee(employeeRepository.save(EmployeeMapper.mapToEmployeeEntity(employee))) ;
    }

    @Override
    public List<Employee> findAll() {
        return EmployeeMapper.mapToListEmployee(
                employeeRepository.findAll()
        );
    }
}
