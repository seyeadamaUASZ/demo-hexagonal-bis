package com.sid.gl.domain.port.incoming;

import com.sid.gl.common.dto.DepartmentRequestDto;
import com.sid.gl.common.dto.DepartmentResponse;


import java.util.List;

public interface DepartmentUseCasePort {
    DepartmentResponse saveDepartment(DepartmentRequestDto dto);
    List<DepartmentResponse> findAll();


}
