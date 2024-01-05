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
      Employee employee = Employee.Builder.builder()
                              .firstName(employeeDto.getFirstName())
                              .lastName(employeeDto.getLastName())
                              .email(employeeDto.getEmail())
                              .build();
      return employee;
  }

  static EmployeeResponse mapToEmployeeRespons(Employee employee){
       EmployeeResponse employeeResponse = new EmployeeResponse();
       employeeResponse.setId(employee.getId());
       employeeResponse.setDepartment(employee.getDepartment().getName());
       String fullName = employee.getFirstName() + " "+ employee.getLastName();
       employeeResponse.setFullName(fullName);
       employeeResponse.setEmail(employee.getEmail());
       return employeeResponse;
  }

  static Department mapToDepartment(DepartmentRequestDto dto){
       Department department = Department.Builder.builder().name(dto.getName())
               .description(dto.getDescription())
               .build();
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

  static List<EmployeeResponse> mapListEmployeeResponse(List<Employee> list){
       return list.stream()
               .filter(Objects::nonNull)
               .map(ManageMapper::mapToEmployeeRespons)
               .collect(Collectors.toList());
  }
}
