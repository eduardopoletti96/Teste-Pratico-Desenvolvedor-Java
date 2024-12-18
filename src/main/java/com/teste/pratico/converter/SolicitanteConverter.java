package com.teste.pratico.converter;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.SolicitanteRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named("solicitanteConverter")
@ApplicationScope
public class SolicitanteConverter implements Converter<Solicitante> {

    @Inject
    private SolicitanteRepository solicitanteRepository;

    @Override
    public Solicitante getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return solicitanteRepository.findById(Long.valueOf(s)).orElse(null);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Solicitante solicitante) {
        if (solicitante == null || solicitante.getId() == null) {
            return "";
        }
        return solicitante.getId().toString();
    }
}
