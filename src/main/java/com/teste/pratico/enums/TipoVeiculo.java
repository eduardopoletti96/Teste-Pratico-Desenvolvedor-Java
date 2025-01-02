package com.teste.pratico.enums;

import java.util.Arrays;
import java.util.List;

public enum TipoVeiculo {
    LEVE("Leve"),
    PESADO("Pesado");

    private final String descricao;

    TipoVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static List<TipoVeiculo> getTodosTipos() {
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            System.out.println(tipo.getDescricao());
        }
        return Arrays.asList(TipoVeiculo.values());
    }
}
