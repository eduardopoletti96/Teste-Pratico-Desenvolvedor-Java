package com.teste.pratico.controller;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
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

@Named("agendamentoBean")
@ViewScoped
@Getter
@Setter
public class AgendamentoBean implements Serializable {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private SolicitanteService solicitanteService;

    private Agendamento agendamento = new Agendamento();
    private List<Agendamento> agendamentos;
    private Solicitante solicitanteSelecionado;

    @PostConstruct
    public void init() {
        listarAgendamentos();
    }

    public void listarAgendamentos() { agendamentos = agendamentoService.listarAgendamentos(); }

    public void salvarAgendamento() {
        agendamento.setSolicitante(solicitanteSelecionado);
        agendamentoService.salvarAgendamento(agendamento);
        TesteUtils.enviarMensagemSucesso("Agendamento salvo com sucesso!");

        listarAgendamentos();
        limparAgendamento();
    }

    private void limparAgendamento() { agendamento = new Agendamento(); }

    public List<Solicitante> sugerirSolicitantes(String nome) {
        return solicitanteService.listarSolicitantes(nome);
    }
}
