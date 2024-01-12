package com.sid.gl.adapter.api.contracts;

import com.sid.gl.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AppController<T> {
    ResponseEntity<ApiResponse> save(T request);
    ResponseEntity<ApiResponse> findAll();

}
