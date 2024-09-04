package com.tecnica.target.desafios.questaoTres.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnica.target.desafios.questaoTres.Faturamento;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

public class ConvertToFaturamento implements Conversor {
    private final FileConsumer fileConsumer;

    public ConvertToFaturamento(FileConsumer fileConsumer) {
        this.fileConsumer = fileConsumer;
    }

    @Override
    public List<Faturamento> convert(String path) throws IOException {
        List<Faturamento> faturamentos;
        String json = fileConsumer.consume(path)
                .orElseThrow(() -> new NoSuchElementException("Este arquivo está incorreto ou não existe."));

        Type type = new TypeToken<List<Faturamento>>() {
        }.getType();
        faturamentos = new Gson().fromJson(json, type);
        return faturamentos;
    }
}
