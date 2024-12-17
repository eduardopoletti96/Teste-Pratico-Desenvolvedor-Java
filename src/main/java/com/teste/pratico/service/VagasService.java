package com.teste.pratico.service;

import com.teste.pratico.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;
}
