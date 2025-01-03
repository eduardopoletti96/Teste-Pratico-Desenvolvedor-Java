package com.teste.pratico.controller;

import com.teste.pratico.enums.TipoVeiculo;
import com.teste.pratico.model.Vagas;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.service.VagasService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("vagasBean")
@ViewScoped
@Getter
@Setter
public class VagasBean extends BaseController<Vagas, Long> {

    @Autowired
    private VagasService vagasService;

    @Inject
    private EnumBean enumBean;

    private TipoVeiculo tipoVeiculo;

    public VagasBean() {
        super(Vagas.class);
        setEntity(new Vagas());
    }

    @Override
    public BaseService<Vagas, Long> getService() {
        return vagasService;
    }

    @Override
    public void salvar() {
        getEntity().setTipo(tipoVeiculo);
        super.salvar();
        tipoVeiculo = null;
    }
}
