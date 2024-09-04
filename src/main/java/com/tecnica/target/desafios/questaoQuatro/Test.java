package com.tecnica.target.desafios.questaoQuatro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Map<String, BigDecimal> faturamentoMensais = new HashMap<>();
        faturamentoMensais.put("SP", new BigDecimal("67.83643"));
        faturamentoMensais.put("RJ", new BigDecimal("36.67866"));
        faturamentoMensais.put("MG", new BigDecimal("29.22988"));
        faturamentoMensais.put("ES", new BigDecimal("27.16548"));
        faturamentoMensais.put("Outros", new BigDecimal("19.84953"));


        BigDecimal valorTotal = faturamentoMensais.values().stream()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);


        Map<String, BigDecimal> percentualFaturamentoMensais = faturamentoMensais.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .divide(valorTotal, 2, RoundingMode.HALF_UP)
                                .multiply(BigDecimal.valueOf(100))
                ));

        percentualFaturamentoMensais.forEach((estado, percentual) ->
                System.out.println(estado + ": " + percentual + "%"));
    }
}
