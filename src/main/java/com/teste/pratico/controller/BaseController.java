package com.teste.pratico.controller;

import com.teste.pratico.model.BaseEntity;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public abstract class BaseController<T extends BaseEntity> {

    private T entity;
    private List<T> entityList;

    public abstract BaseService<T> getService();

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

}
