package com.sid.gl.adapter.api;

import com.sid.gl.adapter.api.constants.ApiPath;
import com.sid.gl.adapter.api.contracts.AppController;
import com.sid.gl.common.dto.EmployeeRequestDto;
import com.sid.gl.common.dto.EmployeeResponse;
import com.sid.gl.common.response.ApiResponse;
import com.sid.gl.domain.port.incoming.EmployeeUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.API+ApiPath.EMPLOYEE)
public class EmployeeController implements AppController<EmployeeRequestDto> {
    private final EmployeeUseCasePort employeeUseCasePort;

    public EmployeeController(EmployeeUseCasePort employeeUseCasePort) {
        this.employeeUseCasePort = employeeUseCasePort;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody final EmployeeRequestDto request) {
        EmployeeResponse employeeResponse = employeeUseCasePort.saveEmployee(request);
        ApiResponse<EmployeeResponse> response =ApiResponse
                .<EmployeeResponse>builder()
                .status(ApiPath.SUCCESS)
                .results(employeeResponse)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> findAll() {
        List<EmployeeResponse> list = employeeUseCasePort.findAll();
        ApiResponse<List<EmployeeResponse>> response =ApiResponse
                .<List<EmployeeResponse>>builder()
                .status(ApiPath.SUCCESS)
                .results(list)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/"+ApiPath.EMPLOYEE_BY_DEP)
    public ResponseEntity<ApiResponse> getEmployeeByDep(){
        Map<String,List<EmployeeResponse>> employees = employeeUseCasePort.getEmployeeByDepartment();
        ApiResponse<Map<String,List<EmployeeResponse>>> response =ApiResponse
                .<Map<String,List<EmployeeResponse>>>builder()
                .status(ApiPath.SUCCESS)
                .results(employees)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
