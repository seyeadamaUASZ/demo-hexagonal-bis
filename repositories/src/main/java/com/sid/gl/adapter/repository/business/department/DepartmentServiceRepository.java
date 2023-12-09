package com.sid.gl.adapter.repository.business.department;

import com.sid.gl.domain.model.Department;
import com.sid.gl.domain.port.outgoing.DepartmentRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceRepository implements DepartmentRepositoryPort {

    private final DepartRepository departRepository;

    public DepartmentServiceRepository(DepartRepository departRepository) {
        this.departRepository = departRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return DepartmentMapper.mapToDepartment(departRepository.save(DepartmentMapper.mapToDepartmentEntity(department)));
    }

    @Override
    public List<Department> findAll() {
        return DepartmentMapper.mapListDepartmentEntityToListDepartment(
                departRepository.findAll()
        );
    }
}
