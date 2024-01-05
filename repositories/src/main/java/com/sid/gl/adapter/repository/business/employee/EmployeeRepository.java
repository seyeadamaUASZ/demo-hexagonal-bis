package com.sid.gl.adapter.repository.business.employee;

import com.sid.gl.adapter.repository.business.entities.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
