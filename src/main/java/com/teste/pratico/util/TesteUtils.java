package com.teste.pratico.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class TesteUtils {

    private TesteUtils() {}

    public static void
    enviarMensagemSucesso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
    }

    public static void enviarMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
    }
}
