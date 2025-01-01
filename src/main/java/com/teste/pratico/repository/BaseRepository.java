package com.teste.pratico.repository;

import com.teste.pratico.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BaseRepository <T extends BaseEntity> extends JpaRepository<T, Long> {
}
