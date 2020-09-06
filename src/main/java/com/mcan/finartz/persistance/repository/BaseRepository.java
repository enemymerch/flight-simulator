package com.mcan.finartz.persistance.repository;

import com.mcan.finartz.persistance.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
