package com.teste.pratico.controller;

import com.teste.pratico.model.BaseEntity;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class BaseController<T extends BaseEntity> {

    private T entity;
    private List<T> entityList;
    private Class<T> entityClass;

    public abstract BaseService<T> getService();

    public BaseController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PostConstruct
    public void init() {
        listarComLimite();
    }

    public void listarComLimite() {
        entityList = getService().listarComLimite(10);
    }

    public void listarTodos() {
        entityList = getService().listar();
    }

    public void salvar() {
        try {
            getService().salvar(entity);
            TesteUtils.enviarMensagemSucesso("Salvo com sucesso!");
            listarComLimite();
            limparEntidade(entityClass);
        } catch (Exception e) {
            TesteUtils.enviarMensagemErro(e.getMessage());
        }
    }

    public void excluir(T entity) {
        getService().excluir(entity);
        TesteUtils.enviarMensagemSucesso("Excluido com sucesso!");
        listarComLimite();
    }

    public void excluir(Long id) {
        getService().excluirById(id);
        TesteUtils.enviarMensagemSucesso("Excluido com sucesso!");
        listarComLimite();
    }

    public T findById(Long id) {
        return getService().findById(id).orElse(null);
    }

    public void limparLista() {
        entityList = new ArrayList<>();
    }

    public void limparEntidade(Class<T> entityClass) throws Exception {
        Constructor<T> constructor = entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        entity = constructor.newInstance();
    }

}
