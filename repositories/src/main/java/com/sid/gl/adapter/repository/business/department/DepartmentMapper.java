package com.sid.gl.adapter.repository.business.department;

import com.sid.gl.adapter.repository.business.entities.DepartmentEntity;
import com.sid.gl.domain.model.Department;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DepartmentMapper {
    public static DepartmentEntity mapToDepartmentEntity(Department department){
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDescription(department.getDescription());
        entity.setName(department.getName());
        return entity;
    }

    public static Department mapToDepartment(DepartmentEntity entity){
        return  Department.Builder.builder()
                                .name(entity.getName())
                                .description(entity.getDescription())
                                .id(entity.getId())
                                 .build();
    }

   public  static List<Department> mapListDepartmentEntityToListDepartment(List<DepartmentEntity> list){
        return list.stream()
                .filter(Objects::nonNull)
                .map(DepartmentMapper::mapToDepartment)
                .collect(Collectors.toList());
    }

}
