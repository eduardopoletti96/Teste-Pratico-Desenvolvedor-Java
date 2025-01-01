package com.teste.pratico.service;

import com.teste.pratico.model.BaseEntity;
import com.teste.pratico.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity> {

    @Autowired
    private BaseRepository<T> repository;

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public List<T> listar() {
        return repository.findAll();
    }

    public List<T> listarComLimite(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return repository.findAll(pageable).getContent();
    }

    @Transactional
    public void salvar(T entity) {
        repository.save(entity);
    }

    @Transactional
    public void excluir(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void excluirById(Long id) {
        repository.deleteById(id);
    }
}
