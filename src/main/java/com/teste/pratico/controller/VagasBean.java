package com.teste.pratico.controller;

import com.teste.pratico.exception.ValidacaoVagasException;
import com.teste.pratico.model.Vagas;
import com.teste.pratico.service.VagasService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("vagasBean")
@ViewScoped
@Getter
@Setter
public class VagasBean {

    @Autowired
    private VagasService vagasService;

    private Vagas vagas = new Vagas();
    private List<Vagas> vagasList;
    private String tipoSelecionado;
    private List<String> opcoesTipo;

    @PostConstruct
    public void init() {

        listarVagas();
        opcoesTipo = new ArrayList<>();
        opcoesTipo.add("Leve");
        opcoesTipo.add("Pesado");
    }

    public void salvarVagas() {
        try {
            vagas.setTipo(tipoSelecionado);
            vagasService.salvarVagas(vagas);
        } catch (ValidacaoVagasException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return;
        }
        TesteUtils.enviarMensagemSucesso("Vagas cadastradas com sucesso!");
        listarVagas();
        limparVagas();
    }

    private void limparVagas() {
        vagas = new Vagas();
        tipoSelecionado = "";
    }

    public void listarVagas() { vagasList = vagasService.listarVagas(); }

    public void excluirVagas(Vagas vaga) {
        vagasService.excluirVagas(vaga);
        TesteUtils.enviarMensagemSucesso("Vagas removidas com sucesso!");

        listarVagas();
    }
}
