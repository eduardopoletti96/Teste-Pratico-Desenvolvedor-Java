package com.teste.pratico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalAgendamentoDTO {
    private String nomeSolicitante;
    private Long totalAgendamentos;
    private Long quantidadeVagas;

    public Double getPercentualVagasPorAgendamento() {
        if (totalAgendamentos == null || quantidadeVagas == 0) {
            return 0.0;
        }
        return (totalAgendamentos.doubleValue() / quantidadeVagas) * 100;
     }
}
