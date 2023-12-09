package com.sid.gl.adapter.repository.business.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
