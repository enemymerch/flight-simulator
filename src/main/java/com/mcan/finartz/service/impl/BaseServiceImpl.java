package com.mcan.finartz.service.impl;

import com.mcan.finartz.api.request.BaseRequest;
import com.mcan.finartz.api.response.BaseResponse;
import com.mcan.finartz.exception.DataNotFoundException;
import com.mcan.finartz.service.mapper.BaseServiceMapper;
import com.mcan.finartz.persistance.entity.BaseEntity;
import com.mcan.finartz.persistance.repository.BaseRepository;
import com.mcan.finartz.service.BaseService;
import com.mcan.finartz.service.dto.BaseDto;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public abstract class BaseServiceImpl<T extends BaseDto, K extends BaseEntity, L extends BaseRepository, M extends BaseServiceMapper<T, K>> implements BaseService<T> {

    protected L l;
    protected M m;

    @Override
    public List<T> getAll() {
        return m.entityListToDtoList(l.findAll());
    }

    @Override
    public T getById(Long id) throws Throwable {
        return m.entityToDto((K) l.findById(id).orElseThrow(DataNotFoundException::new));
    }

    @Override
    public T create(T t) {
        return m.entityToDto((K) l.save(m.dtoToEntity(t)));
    }

    @Override
    public T update(Long id, T t) throws Throwable {
        K k = (K) l.findById(id).orElseThrow(DataNotFoundException::new);
        k = updateFields(k, t);
        return m.entityToDto((K) l.save(k));
    }

    @Override
    public void delete(Long id) {
        l.deleteById(id);
    }

    /**
     * updates entity fields according to dto
     *
     * @param l
     * @param t
     * @return
     */
    protected abstract K updateFields(K l, T t);
}
