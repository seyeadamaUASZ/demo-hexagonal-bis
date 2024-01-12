package com.sid.gl.adapter.api;

import com.sid.gl.adapter.api.constants.ApiPath;
import com.sid.gl.adapter.api.contracts.AppController;
import com.sid.gl.common.dto.DepartmentRequestDto;
import com.sid.gl.common.dto.DepartmentResponse;
import com.sid.gl.common.response.ApiResponse;
import com.sid.gl.domain.port.incoming.DepartmentUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiPath.API+"department")
public class DepartmentController implements AppController<DepartmentRequestDto> {
    private final DepartmentUseCasePort departmentUseCasePort;

    public DepartmentController(DepartmentUseCasePort departmentUseCasePort) {
        this.departmentUseCasePort = departmentUseCasePort;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody final DepartmentRequestDto request) {
        DepartmentResponse departmentResponse = departmentUseCasePort.saveDepartment(request);
        ApiResponse<DepartmentResponse> response =ApiResponse
                .<DepartmentResponse>builder()
                .status(ApiPath.SUCCESS)
                .results(departmentResponse)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> findAll() {
        List<DepartmentResponse> list = departmentUseCasePort.findAll();
        ApiResponse<List<DepartmentResponse>> response =ApiResponse
                .<List<DepartmentResponse>>builder()
                .status(ApiPath.SUCCESS)
                .results(list)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
