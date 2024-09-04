package com.tecnica.target.desafios.questaoTres.service;

import com.tecnica.target.desafios.questaoTres.Faturamento;

import java.io.IOException;
import java.util.List;

public interface Conversor {
    List<Faturamento> convert(String path) throws IOException;
}
