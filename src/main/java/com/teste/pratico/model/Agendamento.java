package com.teste.pratico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "agendamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "numero", length = 20, nullable = false)
    private String numero;

    @Column(name = "motivo", length = 255, nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", referencedColumnName = "id")
    private Solicitante solicitante;

    @Transient
    private Date dataInicio;

    @Transient
    private Date dataFim;

}
