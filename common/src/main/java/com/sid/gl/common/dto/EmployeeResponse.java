package com.sid.gl.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String email;
    private String Department;

}
