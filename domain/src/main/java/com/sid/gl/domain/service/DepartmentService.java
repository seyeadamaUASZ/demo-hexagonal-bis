package com.sid.gl.domain.service;

import com.sid.gl.common.dto.DepartmentRequestDto;
import com.sid.gl.common.dto.DepartmentResponse;
import com.sid.gl.domain.mapper.ManageMapper;
import com.sid.gl.domain.port.incoming.DepartmentUseCasePort;
import com.sid.gl.domain.port.outgoing.DepartmentRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService implements DepartmentUseCasePort {
    private final DepartmentRepositoryPort departmentRepositoryPort;

    public DepartmentService(DepartmentRepositoryPort departmentRepositoryPort) {
        this.departmentRepositoryPort = departmentRepositoryPort;
    }

    @Override
    public DepartmentResponse saveDepartment(DepartmentRequestDto dto) {
         return ManageMapper.mapToDepartmentResponse(
                departmentRepositoryPort.saveDepartment(ManageMapper.mapToDepartment(dto)
                ));
    }

    @Override
    public List<DepartmentResponse> findAll() {
       return ManageMapper.mapToListDepResponse( departmentRepositoryPort.findAll());
    }
}
