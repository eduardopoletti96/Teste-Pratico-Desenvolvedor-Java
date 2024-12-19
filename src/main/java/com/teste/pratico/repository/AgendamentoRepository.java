package com.teste.pratico.repository;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.dto.TotalAgendamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query("SELECT a FROM Agendamento a " +
           "WHERE (:dataInicio IS NULL OR a.data >= :dataInicio) " +
           "AND (:dataFim IS NULL OR a.data <= :dataFim) " +
           "AND (:solicitante IS NULL OR a.solicitante = :solicitante)")
    List<Agendamento> buscarAgendamentos(
            @Param("dataInicio") Date dataInicio,
            @Param("dataFim") Date dataFim,
            @Param("solicitante")Solicitante solicitante
            );

    @Query("SELECT new com.teste.pratico.dto.TotalAgendamentoDTO( " +
           "s.nome, " +
           "COUNT(a.id), " +
           "(SELECT COALESCE(SUM(v.quantidade), 0) " +
           " FROM Vagas v " +
           " WHERE v.inicio >= :dataInicio " +
           "   AND v.fim <= :dataFim)" +
           ") " +
           "FROM Agendamento a " +
           "JOIN a.solicitante s " +
           "WHERE (:dataInicio IS NULL OR a.data >= :dataInicio) " +
           "AND (:dataFim IS NULL OR a.data <= :dataFim) " +
           "AND (:solicitante IS NULL OR a.solicitante = :solicitante)" +
           "GROUP BY s.nome"
    )
    List<TotalAgendamentoDTO> buscarTotalAgendamentos(
            @Param("dataInicio") Date dataInicio,
            @Param("dataFim") Date dataFim,
            @Param("solicitante")Solicitante solicitante
    );

    @Query("SELECT COUNT(a) FROM Agendamento a WHERE a.data >= :dataInicio AND a.data <= :dataFim")
    Long contarAgendamentosPorPeriodo(@Param("dataInicio") Date dataInicio,
                                      @Param("dataFim") Date dataFim);

    @Query("SELECT COUNT(a) FROM Agendamento a WHERE a.solicitante = :solicitante AND a.data >= :dataInicio AND a.data <= :dataFim")
    Long contarAgendamentosPorPeriodoESolicitante(@Param("dataInicio") Date dataInicio,
                                                  @Param("dataFim") Date dataFim,
                                                  @Param("solicitante") Solicitante solicitante);
}
