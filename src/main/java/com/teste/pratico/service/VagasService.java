package com.teste.pratico.service;

import com.teste.pratico.model.Vagas;
import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    public List<Vagas> listarVagas() {
        return vagasRepository.findAll();
    }

    public List<Vagas> listarVagas(Date inicio, Date fim) {
        return vagasRepository.findAll();
    }

    @Transactional
    public void salvarVagas(Vagas vagas) {
        vagasRepository.save(vagas);
    }

    @Transactional
    public void excluirVagas(Vagas vagas) {
        vagasRepository.delete(vagas);
    }
}
