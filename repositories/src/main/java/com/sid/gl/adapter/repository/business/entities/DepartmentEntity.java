package com.sid.gl.adapter.repository.business.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_department")
@Getter
@Setter
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom",length = 100,unique = true)
    private String name;
    @Column(name = "description")
    private String description;
   /* @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EmployeeEntity> employees;*/
}
