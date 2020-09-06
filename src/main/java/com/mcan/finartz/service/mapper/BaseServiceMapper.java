package com.mcan.finartz.service.mapper;

import com.mcan.finartz.persistance.entity.BaseEntity;
import com.mcan.finartz.service.dto.BaseDto;

import java.util.List;

public interface BaseServiceMapper<T extends BaseDto, K extends BaseEntity> {
    T entityToDto(K k);

    K dtoToEntity(T t);

    List<T> entityListToDtoList(List<K> kList);

}
