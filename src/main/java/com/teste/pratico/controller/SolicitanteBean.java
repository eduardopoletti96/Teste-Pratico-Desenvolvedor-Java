package com.teste.pratico.controller;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.SolicitanteService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named("solicitanteBean")
@ViewScoped
@Getter
@Setter
public class SolicitanteBean {

    @Autowired
    private SolicitanteService solicitanteService;

    private Solicitante solicitante = new Solicitante();
    private List<Solicitante> solicitantes;

    @PostConstruct
    public void init() {
        listarSolicitantes();
    }

    public void salvarSolicitante() {
        solicitanteService.salvarSolicitante(solicitante);
        TesteUtils.enviarMensagemSucesso("Solicitante salvo com sucesso!");

        listarSolicitantes();
        limparSolicitante();
    }

    private void limparSolicitante() {
        solicitante = new Solicitante();
    }

    public void listarSolicitantes() {
        solicitantes = solicitanteService.listarSolicitantes();
    }

    public void excluirSolicitante(Solicitante solicitante) {
        solicitanteService.excluirSolicitante(solicitante);
        TesteUtils.enviarMensagemSucesso("Solicitante removido com sucesso!");

        listarSolicitantes();
    }

}
