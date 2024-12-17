package com.teste.pratico.service;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public List<Agendamento> listarAgendamentos(Date inicio, Date fim, Solicitante solicitante) {
        return null;
    }

    public void salvarAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
    }
}
