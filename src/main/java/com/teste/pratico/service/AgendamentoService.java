package com.teste.pratico.service;

import com.teste.pratico.dto.TotalAgendamentoDTO;
import com.teste.pratico.exception.AgendamentoException;
import com.teste.pratico.model.Agendamento;
import com.teste.pratico.repository.AgendamentoRepository;
import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private VagasRepository vagasRepository;

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public List<Agendamento> listarAgendamentos(Agendamento agendamento) {
        return agendamentoRepository.buscarAgendamentos(agendamento.getDataInicio(), agendamento.getDataFim(), agendamento.getSolicitante());
    }

    public List<TotalAgendamentoDTO> buscarTotalAgendamentos(Agendamento agendamento) {
        return agendamentoRepository.buscarTotalAgendamentos(agendamento.getDataInicio(), agendamento.getDataFim(), agendamento.getSolicitante());
    }

    public void salvarAgendamento(Agendamento agendamento) {
        verificaDisponibilidadeVagaParaAgendamento(agendamento);
        agendamentoRepository.save(agendamento);
    }

    private void verificaDisponibilidadeVagaParaAgendamento(Agendamento agendamento) {
        Integer totalVagasDisponiveis = vagasRepository.somaQuantidadeVagasPorPeriodo(agendamento.getData(), agendamento.getTipo());

        Date menorDataInicio = vagasRepository.menorDataInicio(agendamento.getData());

        Date maiorDataFim = vagasRepository.maiorDataFim(agendamento.getData());

        Long totalAgendamentos = agendamentoRepository.contarAgendamentosPorPeriodo(menorDataInicio, maiorDataFim);

        if (totalVagasDisponiveis <= totalAgendamentos) {
            throw new AgendamentoException("Não há mais vagas disponíveis para a data solicitada!");
        }

        Long totalAgendamentosSolicitante = agendamentoRepository.contarAgendamentosPorPeriodoESolicitanteETipoVeiculo(menorDataInicio, maiorDataFim, agendamento.getSolicitante(), agendamento.getTipo());

        if (totalAgendamentosSolicitante >= totalVagasDisponiveis * 0.25) {
            throw new AgendamentoException("O mesmo solicitante não pode ocupar mais do que 25% das vagas do período para o mesmo tipo de Veículo!");
        }

    }

    public void excluirAgendamento(Agendamento agendamento) { agendamentoRepository.delete(agendamento); }
}
