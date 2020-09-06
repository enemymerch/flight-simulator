package com.mcan.finartz.api;

import com.mcan.finartz.api.mapper.BaseApiMapper;
import com.mcan.finartz.api.request.BaseRequest;
import com.mcan.finartz.api.response.BaseResponse;
import com.mcan.finartz.service.BaseService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class BaseController<J extends BaseService, M extends BaseApiMapper, P extends BaseResponse, R extends BaseRequest> {

    private J service;
    private M mapper;

    @GetMapping
    public ResponseEntity<List<P>> getAll() {
        return new ResponseEntity<>(mapper.dtoListToResponseList(service.getAll()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<P> getById(@Validated @PathVariable Long id) throws Throwable {
        return new ResponseEntity(mapper.dtoToResponse(service.getById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<P> create(@RequestBody R request) {
        return new ResponseEntity(mapper.dtoToResponse(service.create(mapper.requestToDto(request))), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<P> update(@Validated @PathVariable Long id, @RequestBody R request) throws Throwable {
        return new ResponseEntity(mapper.dtoToResponse(service.update(id, mapper.requestToDto(request))), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@Validated @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
