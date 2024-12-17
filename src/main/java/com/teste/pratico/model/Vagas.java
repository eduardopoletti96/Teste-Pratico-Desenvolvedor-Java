package com.teste.pratico.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vagas")
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
}
