package com.teste.pratico.service;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (nome == null || nome.isEmpty()) {
            return listarSolicitantes();
        }
        return solicitanteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Transactional
    public void salvarSolicitante(Solicitante solicitante) {
        solicitanteRepository.save(solicitante);
    }

    @Transactional
    public void excluirSolicitante(Solicitante solicitante) {
        solicitanteRepository.delete(solicitante);
    }
}
