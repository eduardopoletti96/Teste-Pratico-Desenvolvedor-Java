package com.teste.pratico.service;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SolicitanteService {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    public List<Solicitante> listarSolicitantes() {
        return solicitanteRepository.findAll();
    }

    public List<Solicitante> listarSolicitantes(String nome) {
        return null;
    }

    public void salvarSolicitante(Solicitante solicitante) {
        solicitanteRepository.save(solicitante);
    }
}
