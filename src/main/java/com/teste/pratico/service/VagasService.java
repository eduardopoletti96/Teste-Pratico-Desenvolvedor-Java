package com.teste.pratico.service;

import com.teste.pratico.exception.ValidacaoVagasException;
import com.teste.pratico.model.Vagas;
import com.teste.pratico.repository.BaseRepository;
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
public class VagasService extends BaseService<Vagas, Long> {

    @Autowired
    private VagasRepository vagasRepository;

    public List<Vagas> listarVagas(Date inicio, Date fim) {
        return vagasRepository.findAll();
    }

    @Override
    protected BaseRepository<Vagas, Long> getRepository() {
        return vagasRepository;
    }

    @Override
    public void salvar(Vagas entity) {
        validarInsercaoVagas(entity);
        super.salvar(entity);
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
}
