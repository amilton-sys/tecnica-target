package com.tecnica.target.desafios.questaoTres.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class ConsumerJson implements FileConsumer {
    @Override
    public Optional<String> consume(String path) throws IOException {
        Path diretorio = Paths.get(path);
        if (Files.exists(diretorio)) {
            return Optional.of(String.join(" ", Files.readAllLines(diretorio, StandardCharsets.UTF_8)));
        }
        return Optional.empty();
    }
}
