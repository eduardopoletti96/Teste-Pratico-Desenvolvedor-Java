package com.teste.pratico.beans;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.service.AgendamentoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("agendamentoBean")
@ViewScoped
@Getter
@Setter
public class AgendamentoBean implements Serializable {

    @Autowired
    private AgendamentoService agendamentoService;

    private Agendamento agendamento = new Agendamento();

    public void salvarAgendamento() {
        agendamentoService.salvarAgendamento(agendamento);
        agendamento = new Agendamento();
    }
}
