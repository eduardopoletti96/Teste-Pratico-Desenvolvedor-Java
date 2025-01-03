package com.teste.pratico.controller;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.service.SolicitanteService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("solicitanteBean")
@ViewScoped
@Getter
@Setter
public class SolicitanteBean extends BaseController<Solicitante, Long>{

    @Autowired
    private SolicitanteService solicitanteService;

    public SolicitanteBean() {
        super(Solicitante.class);
        setEntity(new Solicitante());
    }

    @Override
    public BaseService<Solicitante, Long> getService() {
        return solicitanteService;
    }

}
