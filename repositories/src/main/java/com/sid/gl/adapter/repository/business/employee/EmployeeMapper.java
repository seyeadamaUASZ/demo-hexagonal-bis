package com.sid.gl.adapter.repository.business.employee;

import com.sid.gl.adapter.repository.business.department.DepartmentMapper;
import com.sid.gl.adapter.repository.business.entities.EmployeeEntity;
import com.sid.gl.domain.model.Department;
import com.sid.gl.domain.model.Employee;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeMapper {
    public static EmployeeEntity mapToEmployeeEntity(Employee employee){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setLastName(employee.getLastName());
        return employeeEntity;
    }

    public static Employee mapToEmployee(EmployeeEntity employeeEntity){
        return Employee.Builder.builder()
                .id(employeeEntity.getId())
                .email(employeeEntity.getEmail())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .department(DepartmentMapper.mapToDepartment(employeeEntity.getDepartment()))
                .build();
    }

    public  static List<Employee> mapToListEmployee(List<EmployeeEntity> list){
        return list.stream()
                .filter(Objects::nonNull)
                .map(EmployeeMapper::mapToEmployee)
                .collect(Collectors.toList());
    }

}
