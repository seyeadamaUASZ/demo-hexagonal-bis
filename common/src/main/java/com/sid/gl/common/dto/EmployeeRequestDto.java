package com.sid.gl.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String  department;
}
