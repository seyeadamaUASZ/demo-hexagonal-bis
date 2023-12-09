package com.sid.gl.domain.mapper;

import com.sid.gl.common.dto.DepartmentRequestDto;
import com.sid.gl.common.dto.DepartmentResponse;
import com.sid.gl.common.dto.EmployeeRequestDto;
import com.sid.gl.common.dto.EmployeeResponse;
import com.sid.gl.domain.model.Department;
import com.sid.gl.domain.model.Employee;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ManageMapper {
   static Employee mapEmployeeDtoToEmployee(EmployeeRequestDto employeeDto){
      Employee employee = new Employee();
      employee.setFirstName(employeeDto.getFirstName());
      employee.setLastName(employeeDto.getLastName());
      employee.setEmail(employeeDto.getEmail());
      employee.setDepartment(employeeDto.getDepartment());
      return employee;
  }

  static EmployeeResponse mapToEmployeeRespons(Employee employee){
       EmployeeResponse employeeResponse = new EmployeeResponse();
       employeeResponse.setId(employee.getId());
       employeeResponse.setDepartment(employee.getDepartment());
       String fullName = employee.getFirstName() + " "+ employee.getLastName();
       employeeResponse.setFullName(fullName);
       employeeResponse.setEmail(employee.getEmail());
       return employeeResponse;
  }

  static Department mapToDepartment(DepartmentRequestDto dto){
       Department department = new Department();
       department.setName(dto.getName());
       department.setDescription(dto.getDescription());
       return department;
  }

  static DepartmentResponse mapToDepartmentResponse(Department department){
       DepartmentResponse response = new DepartmentResponse();
       response.setId(department.getId());
       response.setDescription(department.getDescription());
       response.setName(department.getName());
       return response;
  }

  static List<DepartmentResponse> mapToListDepResponse(List<Department> list){
       return list.stream()
               .filter(Objects::nonNull)
               .map(ManageMapper::mapToDepartmentResponse)
               .collect(Collectors.toList());
  }
}
