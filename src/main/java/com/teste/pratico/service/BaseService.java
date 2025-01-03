package com.teste.pratico.service;

import com.teste.pratico.model.BaseEntity;
import com.teste.pratico.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    protected abstract BaseRepository<T, ID> getRepository();

    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public List<T> listar() {
        return getRepository().findAll();
    }

    public List<T> listarComLimite(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return getRepository().findAll(pageable).getContent();
    }

    public List<T> listarComLimitePadrao(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return getRepository().findAll(pageable).getContent();
    }

    public int count() {
        return (int) getRepository().count();
    }

    @Transactional
    public void salvar(T entity) {
        getRepository().save(entity);
    }

    @Transactional
    public void excluir(T entity) {
        getRepository().delete(entity);
    }

    @Transactional
    public void excluirById(ID id) {
        getRepository().deleteById(id);
    }
}
