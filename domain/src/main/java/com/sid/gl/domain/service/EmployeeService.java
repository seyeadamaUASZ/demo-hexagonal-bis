package com.sid.gl.domain.service;

import com.sid.gl.common.dto.EmployeeRequestDto;
import com.sid.gl.common.dto.EmployeeResponse;
import com.sid.gl.common.exceptions.ResourceNotFoundException;
import com.sid.gl.domain.mapper.ManageMapper;
import com.sid.gl.domain.model.Department;
import com.sid.gl.domain.model.Employee;
import com.sid.gl.domain.port.incoming.EmployeeUseCasePort;
import com.sid.gl.domain.port.outgoing.DepartmentRepositoryPort;
import com.sid.gl.domain.port.outgoing.EmployeeRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeService implements EmployeeUseCasePort {
    private final EmployeeRepositoryPort employeeRepositoryPort;
    private final DepartmentRepositoryPort departmentRepositoryPort;

    public EmployeeService(EmployeeRepositoryPort employeeRepositoryPort, DepartmentRepositoryPort departmentRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
        this.departmentRepositoryPort = departmentRepositoryPort;
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequestDto employeeRequestDto) {
        log.info("Save Employee .... {} ",employeeRequestDto);
        Employee employee = ManageMapper.mapEmployeeDtoToEmployee(employeeRequestDto);
        Department department = departmentRepositoryPort.getDepartment(employeeRequestDto.getDepartmentId());
        /*if(Objects.isNull(department))
             throw new ResourceNotFoundException("Invalid saved employee because Department not found !!!");*/
        employee.setDepartment(department);
        return ManageMapper.mapToEmployeeRespons(employeeRepositoryPort.saveEmployee(employee));
    }

    @Override
    public List<EmployeeResponse> findAll() {
        log.info("Retrieve list employee ....");
        return ManageMapper.mapListEmployeeResponse(employeeRepositoryPort.findAll());
    }
}
