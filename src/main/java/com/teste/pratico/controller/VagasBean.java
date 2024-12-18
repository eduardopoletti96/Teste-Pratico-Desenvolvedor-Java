package com.teste.pratico.controller;

import com.teste.pratico.model.Vagas;
import com.teste.pratico.service.VagasService;
import com.teste.pratico.util.TesteUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
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

    @PostConstruct
    public void init() {
        listarVagas();
    }

    public void salvarVagas() {
        vagasService.salvarVagas(vagas);
        TesteUtils.enviarMensagemSucesso("Vagas cadastradas com sucesso!");

        listarVagas();
        limparVagas();
    }

    private void limparVagas() { vagas = new Vagas(); }

    public void listarVagas() { vagasList = vagasService.listarVagas(); }

    public void excluirVagas(Vagas vaga) {
        vagasService.excluirVagas(vaga);
        TesteUtils.enviarMensagemSucesso("Vagas removidas com sucesso!");

        listarVagas();
    }
}
