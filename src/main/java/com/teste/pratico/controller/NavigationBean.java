package com.teste.pratico.controller;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("navigateBean")
public class NavigationBean {

    public void navigateToHome() {
        navigate("index.xhtml");
    }

    public void navigateToCadastroVagas() {
        navigate("vagas.xhtml");
    }

    public void navigateToCadastroSolicitantes() {
        navigate("solicitante.xhtml");
    }

    public void navigateToCadastroAgendamentos() {
        navigate("agendamentos.xhtml");
    }

    public void navigateToConsultaAgendamentos() {
        navigate("consulta-agendamentos.xhtml");
    }

    public void navigateToConsultaTotalAgendamentos() {
        navigate("consulta-total-agendamentos.xhtml");
    }

    private void navigate(String page) {
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
        navigationHandler.handleNavigation(context, null, page);
    }
}
