package com.teste.pratico.repository;

import com.teste.pratico.model.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VagasRepository extends BaseRepository<Vagas, Long> {

    @Query("SELECT v FROM Vagas v WHERE v.fim <= :dataAgendamento")
    List<Vagas> buscarVagasPorDataAgendamento(@Param("dataAgendamento") Date dataAgendamento);

    @Query("SELECT COALESCE(SUM(v.quantidade), 0) FROM Vagas v WHERE LOWER(v.tipo) = LOWER(:tipoVeiculo) AND v.inicio <= :dataAgendamento AND v.fim >= :dataAgendamento")
    Integer somaQuantidadeVagasPorPeriodo(@Param("dataAgendamento") Date dataAgendamento,
                                          @Param("tipoVeiculo") String tipoVeiculo);

    @Query("SELECT MIN(v.inicio) FROM Vagas v WHERE v.inicio <= :dataAgendamento AND v.fim >= :dataAgendamento")
    Date menorDataInicio(@Param("dataAgendamento") Date dataAgendamento);

    @Query("SELECT MAX(v.fim) FROM Vagas v WHERE v.fim >= :dataAgendamento AND v.inicio <= :dataAgendamento")
    Date maiorDataFim(@Param("dataAgendamento") Date dataAgendamento);

}


