package com.teste.pratico.controller;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.SolicitanteService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("consultaAgendamentosBean")
@ViewScoped
@Getter
@Setter
public class ConsultaAgendamentosBean implements Serializable {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private SolicitanteService solicitanteService;

    private List<Agendamento> agendamentos;
    private Agendamento agendamentoBusca = new Agendamento();

    public List<Solicitante> sugerirSolicitantes(String nome) {
        return solicitanteService.listarSolicitantes(nome);
    }

    public void buscarAgendamentos() {
        agendamentos = agendamentoService.listarAgendamentos(agendamentoBusca);
    }
}
