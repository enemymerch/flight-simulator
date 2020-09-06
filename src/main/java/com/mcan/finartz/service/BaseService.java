package com.mcan.finartz.service;

import com.mcan.finartz.service.dto.BaseDto;

import java.util.List;

public interface BaseService<T extends BaseDto> {
    List<T> getAll();

    T getById(Long id) throws Throwable;

    T create(T t);

    T update(Long id, T t) throws Throwable;

    void delete(Long id);
}
