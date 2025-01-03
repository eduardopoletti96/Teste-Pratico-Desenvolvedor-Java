package com.teste.pratico.controller;

import com.teste.pratico.model.BaseEntity;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public abstract class BaseController<T extends BaseEntity<ID>, ID extends Serializable> implements Serializable {

    private T entity;
    private List<T> entityList;
    private Class<T> entityClass;
    private LazyDataModel<T> lazyModel;

    public abstract BaseService<T, ID> getService();

    public BaseController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PostConstruct
    public void init() {
        configureLazyModel();
    }

    public void configureLazyModel() {
        lazyModel = new LazyDataModel<T>() {

            @Override
            public int count(Map<String, FilterMeta> map) {
                return getService().count();
            }

            @Override
            public List<T> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filter) {
                int page = first / pageSize;

                return getService().listarComLimitePadrao(page, pageSize);
            }
        };
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

    public void excluir(ID id) {
        getService().excluirById(id);
        TesteUtils.enviarMensagemSucesso("Excluido com sucesso!");
        listarComLimite();
    }

    public T findById(ID id) {
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
