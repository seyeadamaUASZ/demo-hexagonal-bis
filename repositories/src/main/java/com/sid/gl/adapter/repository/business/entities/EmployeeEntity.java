package com.sid.gl.adapter.repository.business.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tb_employee")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_prenom")
    private String firstName;
    @Column(name = "employee_nom")
    private String lastName;
    @Column(name = "employee_email",unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

}
