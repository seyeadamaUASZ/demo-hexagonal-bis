package com.sid.gl.adapter.repository.business.department;

import com.sid.gl.common.exceptions.ResourceNotFoundException;
import com.sid.gl.domain.model.Department;
import com.sid.gl.domain.port.outgoing.DepartmentRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceRepository implements DepartmentRepositoryPort {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        //for validation
        department.validate();
        return DepartmentMapper.mapToDepartment(departmentRepository.save(DepartmentMapper.mapToDepartmentEntity(department)));
    }

    @Override
    public List<Department> findAll() {
        return DepartmentMapper.mapListDepartmentEntityToListDepartment(
                departmentRepository.findAll()
        );
    }

    @Override
    public Department getDepartment(Long id) {
        return DepartmentMapper.mapToDepartment(departmentRepository.findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Department with id not found !!!"))
        );
    }
}
