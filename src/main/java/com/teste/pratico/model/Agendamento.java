package com.teste.pratico.model;

import com.teste.pratico.enums.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "agendamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agendamento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "numero", length = 20, nullable = false)
    private String numero;

    @Column(name = "motivo", length = 255, nullable = false)
    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", length = 255, nullable = false)
    private TipoVeiculo tipo;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", referencedColumnName = "id")
    private Solicitante solicitante;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    private Date dataInicio;

    @Transient
    private Date dataFim;

}
