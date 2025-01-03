package com.teste.pratico.service;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.BaseRepository;
import com.teste.pratico.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SolicitanteService extends BaseService<Solicitante, Long> {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    public List<Solicitante> listarSolicitantes(String nome) {
        if (nome == null || nome.isEmpty()) {
            return listarComLimite(10);
        }
        return solicitanteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    protected BaseRepository<Solicitante, Long> getRepository() {
        return solicitanteRepository;
    }
}
