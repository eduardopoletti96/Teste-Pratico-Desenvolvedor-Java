package com.teste.pratico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vagas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vagas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inicio", nullable = false)
    private Date inicio;

    @Column(name = "fim", nullable = false)
    private Date fim;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "tipo", nullable = false)
    private String tipo;
}
