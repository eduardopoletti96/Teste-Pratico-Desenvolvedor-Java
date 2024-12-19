package com.teste.pratico.controller;

import com.teste.pratico.dto.TotalAgendamentoDTO;
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

@Named("consultaTotalAgendamentosBean")
@ViewScoped
@Getter
@Setter
public class ConsultaTotalAgendamentosBean implements Serializable {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private SolicitanteService solicitanteService;

    private List<TotalAgendamentoDTO> totalAgendamentos;
    private Agendamento agendamentoBusca = new Agendamento();

    public List<Solicitante> sugerirSolicitantes(String nome) { return solicitanteService.listarSolicitantes(nome); }

    public void listarTotalAgendamentos() { this.totalAgendamentos = agendamentoService.buscarTotalAgendamentos(agendamentoBusca); }

}
