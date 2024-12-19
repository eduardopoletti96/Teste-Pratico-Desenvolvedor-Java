package com.teste.pratico.service;

import com.teste.pratico.exception.ValidacaoVagasException;
import com.teste.pratico.model.Vagas;
import com.teste.pratico.repository.VagasRepository;
import com.teste.pratico.util.TesteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
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
        validarInsercaoVagas(vagas);
        vagasRepository.save(vagas);
    }

    private void validarInsercaoVagas(Vagas vagas) {
        validarDataIncioEFIM(vagas);
        validarDataRetroativaVagas(vagas);
    }

    private void validarDataIncioEFIM(Vagas vagas) {
        if (vagas.getInicio().after(vagas.getFim())) {
            throw new ValidacaoVagasException("Não é possível cadastrar vagas com data de Início maior que Fim!");
        }
    }

    private void validarDataRetroativaVagas(Vagas vagas) {
        if (vagas.getInicio().before(TesteUtils.converterLocalDateParaData())){
            throw new ValidacaoVagasException("Não é possível cadastrar vagas com data retroativa!");
        }
    }

    @Transactional
    public void excluirVagas(Vagas vagas) {
        vagasRepository.delete(vagas);
    }
}
