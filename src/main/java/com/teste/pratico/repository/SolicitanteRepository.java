package com.teste.pratico.repository;

import com.teste.pratico.model.Solicitante;

import java.util.List;

public interface SolicitanteRepository extends BaseRepository<Solicitante, Long> {

    List<Solicitante> findByNomeContainingIgnoreCase(String nome);
}
