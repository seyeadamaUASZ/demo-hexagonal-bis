package com.sid.gl.adapter.repository.business.department;

import com.sid.gl.adapter.repository.business.entities.DepartmentEntity;
import com.sid.gl.domain.model.Department;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DepartmentMapper {
    static DepartmentEntity mapToDepartmentEntity(Department department){
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDescription(department.getDescription());
        entity.setName(department.getName());
        return entity;
    }

    static Department mapToDepartment(DepartmentEntity entity){
        Department department = new Department();
        department.setDescription(entity.getDescription());
        department.setName(entity.getName());
        department.setId(entity.getId());
        return department;
    }

    static List<Department> mapListDepartmentEntityToListDepartment(List<DepartmentEntity> list){
        return list.stream()
                .filter(Objects::nonNull)
                .map(DepartmentMapper::mapToDepartment)
                .collect(Collectors.toList());
    }

}
