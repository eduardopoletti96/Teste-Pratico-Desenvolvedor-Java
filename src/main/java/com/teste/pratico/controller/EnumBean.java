package com.teste.pratico.controller;

import com.teste.pratico.enums.TipoVeiculo;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named("enumBean")
@ViewScoped
public class EnumBean {

    public List<TipoVeiculo> getTipoVeiculos() {
        return TipoVeiculo.getTodosTipos();
    }
}
