package com.sid.gl.adapter.repository.business.employee;

import com.sid.gl.adapter.repository.business.department.DepartmentRepository;
import com.sid.gl.adapter.repository.business.entities.DepartmentEntity;
import com.sid.gl.adapter.repository.business.entities.EmployeeEntity;
import com.sid.gl.domain.model.Employee;
import com.sid.gl.domain.port.outgoing.EmployeeRepositoryPort;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceRepository implements EmployeeRepositoryPort {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceRepository(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.validate();
        EmployeeEntity employeeEntity = EmployeeMapper.mapToEmployeeEntity(employee);
        DepartmentEntity departmentEntity = departmentRepository.findById(employee.getDepartment().getId()).get();
        employeeEntity.setDepartment(departmentEntity);
        EmployeeEntity employeeSaved = employeeRepository.save(employeeEntity);
        return EmployeeMapper.mapToEmployee(employeeSaved) ;
    }

    @Override
    public List<Employee> findAll() {
        return EmployeeMapper.mapToListEmployee(
                employeeRepository.findAll()
        );
    }
}
