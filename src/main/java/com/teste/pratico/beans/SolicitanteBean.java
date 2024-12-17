package com.teste.pratico.beans;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.SolicitanteService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
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

    public void salvarSolicitante() {
        solicitanteService.salvarSolicitante(solicitante);
        solicitante = new Solicitante();
    }

    public void listarSolicitantes() {
        solicitantes = solicitanteService.listarSolicitantes();
    }
}
