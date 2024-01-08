package com.sid.gl.domain.port.outgoing;


import com.sid.gl.domain.model.Department;

import java.util.List;

public interface DepartmentRepositoryPort {
    Department saveDepartment(Department department);
    List<Department> findAll();

    Department getDepartment(Long id);
}
