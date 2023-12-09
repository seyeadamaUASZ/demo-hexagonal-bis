package com.sid.gl.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sid.gl.common.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class ApiResponse<T> {
    private String status;
    private List<ErrorDTO> errorDTOS;
    private T results;
}
