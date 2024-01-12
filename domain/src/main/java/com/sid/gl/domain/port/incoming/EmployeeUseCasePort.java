package com.sid.gl.domain.port.incoming;

import com.sid.gl.common.dto.EmployeeRequestDto;
import com.sid.gl.common.dto.EmployeeResponse;

import java.util.List;
import java.util.Map;

public interface EmployeeUseCasePort {
    EmployeeResponse saveEmployee(EmployeeRequestDto employeeRequestDto);
    List<EmployeeResponse> findAll();

    Map<String, List<EmployeeResponse>> getEmployeeByDepartment();
}
