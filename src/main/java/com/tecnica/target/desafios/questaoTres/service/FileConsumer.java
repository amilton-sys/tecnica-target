package com.tecnica.target.desafios.questaoTres.service;

import java.io.IOException;
import java.util.Optional;

public interface FileConsumer {
    Optional<String> consume(String path) throws IOException;
}
