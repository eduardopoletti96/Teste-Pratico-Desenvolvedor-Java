package com.teste.pratico.controller;

import com.teste.pratico.exception.AgendamentoException;
import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.service.SolicitanteService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("agendamentoBean")
@ViewScoped
@Getter
@Setter
public class AgendamentoBean extends BaseController<Agendamento> {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private SolicitanteService solicitanteService;

    private Agendamento agendamento = new Agendamento();
    private List<Agendamento> agendamentos;
    private Solicitante solicitanteSelecionado;
    private String tipoSelecionado;
    private List<String> opcoesTipo;

    @Override
    public BaseService<Agendamento> getService() {
        return agendamentoService;
    }

    @PostConstruct
    public void init() {
        listarAgendamentos();
    }

    public void listarAgendamentos() {
        agendamentos = agendamentoService.listarComLimite(10);
        opcoesTipo = new ArrayList<>();
        opcoesTipo.add("Leve");
        opcoesTipo.add("Pesado");}

    public void salvarAgendamento() {
        agendamento.setTipo(tipoSelecionado);
        agendamento.setSolicitante(solicitanteSelecionado);
        try {
            agendamentoService.salvar(agendamento);
        } catch (AgendamentoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return;
        }
        TesteUtils.enviarMensagemSucesso("Agendamento salvo com sucesso!");

        listarAgendamentos();
        limparAgendamento();
        solicitanteSelecionado = new Solicitante();
    }

    public void excluirAgendamento(Agendamento agendamento) {
        agendamentoService.excluir(agendamento);
        TesteUtils.enviarMensagemSucesso("Agendamento removido com sucesso!");

        listarAgendamentos();
    }

    private void limparAgendamento() {
        agendamento = new Agendamento();
        tipoSelecionado = "";
    }

    public List<Solicitante> sugerirSolicitantes(String nome) {
        return solicitanteService.listarSolicitantes(nome);
    }
}
