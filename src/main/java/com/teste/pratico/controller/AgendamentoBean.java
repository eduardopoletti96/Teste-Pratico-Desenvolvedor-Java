package com.teste.pratico.controller;

import com.teste.pratico.enums.TipoVeiculo;
import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.BaseService;
import com.teste.pratico.service.SolicitanteService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    @Inject
    private EnumBean enumBean;

    private Solicitante solicitanteSelecionado;
    private TipoVeiculo tipoVeiculo;

    public AgendamentoBean() {
        super(Agendamento.class);
        setEntity(new Agendamento());
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public BaseService<Agendamento> getService() {
        return agendamentoService;
    }

    @Override
    public void salvar() {
        getEntity().setTipo(tipoVeiculo);
        getEntity().setSolicitante(solicitanteSelecionado);
        super.salvar();
        solicitanteSelecionado = new Solicitante();
        tipoVeiculo = null;
    }

    @Override
    public void limparLista() {
        super.limparLista();
        tipoVeiculo = null;
    }

    public List<Solicitante> sugerirSolicitantes(String nome) {
        return solicitanteService.listarSolicitantes(nome);
    }
}
