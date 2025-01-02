package com.teste.pratico.converter;

import com.teste.pratico.enums.TipoVeiculo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoVeiculoConverter")
public class TipoVeiculoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;  // Retorna null para valor vazio
        }

        try {
            // Converte a string para o enum, ignorando o case
            return TipoVeiculo.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;  // Caso não encontre um tipo correspondente, retorna null
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";  // Retorna uma string vazia para o valor nulo
        }

        // Verifica se o valor é do tipo TipoVeiculo
        if (value instanceof TipoVeiculo) {
            // Converte o enum para a string correspondente
            return ((TipoVeiculo) value).name();
        }

        // Caso o valor não seja do tipo TipoVeiculo, retorna uma string vazia ou outra mensagem de erro
        return "";
    }
}
