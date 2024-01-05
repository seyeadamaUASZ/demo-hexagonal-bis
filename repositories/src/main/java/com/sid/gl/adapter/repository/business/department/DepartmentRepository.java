package com.sid.gl.adapter.repository.business.department;

import com.sid.gl.adapter.repository.business.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
