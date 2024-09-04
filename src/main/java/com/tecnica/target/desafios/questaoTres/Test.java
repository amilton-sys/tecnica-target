package com.tecnica.target.desafios.questaoTres;

import com.tecnica.target.desafios.questaoTres.service.ConsumerJson;
import com.tecnica.target.desafios.questaoTres.service.Conversor;
import com.tecnica.target.desafios.questaoTres.service.ConvertToFaturamento;
import com.tecnica.target.desafios.questaoTres.service.FileConsumer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Faturamento> faturamentos = getFaturamentos();
        int scale = 2;


        BigDecimal menorValorDiario = getMenorValorDiario(faturamentos, scale);
        BigDecimal maiorValorDiario = getMaiorValorDiario(faturamentos, scale);
        long numeroDiasSuperiorMediaMensal = getNumeroDiasSuperiorMediaMensal(faturamentos, scale);

        System.out.printf("O menor valor de faturamento ocorrido em um dia do mês foi de: %s%n", menorValorDiario);
        System.out.printf("O maior valor de faturamento ocorrido em um dia do mês foi de: %s%n", maiorValorDiario);
        System.out.printf("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal foi de: %s%n", numeroDiasSuperiorMediaMensal);
    }

    private static long getNumeroDiasSuperiorMediaMensal(List<Faturamento> faturamentos, int scale) {
        BigDecimal somaTotal = faturamentos.stream()
                .map(Faturamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(scale, RoundingMode.HALF_UP);

        BigDecimal media = somaTotal.divide(new BigDecimal(faturamentos.size()), scale, RoundingMode.HALF_UP);

        return faturamentos.stream()
                .filter(fat -> fat.getValor().compareTo(media) > 0)
                .count();
    }

    private static BigDecimal getMenorValorDiario(List<Faturamento> faturamentos, int scale) {
        return faturamentos.stream()
                .map(Faturamento::getValor)
                .filter(valor -> valor.compareTo(BigDecimal.ZERO) > 0)
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO)
                .setScale(scale, RoundingMode.HALF_UP);
    }

    private static BigDecimal getMaiorValorDiario(List<Faturamento> faturamentos, int scale) {
        return faturamentos.stream()
                .map(Faturamento::getValor)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO)
                .setScale(scale, RoundingMode.HALF_UP);
    }

    private static List<Faturamento> getFaturamentos() {
        FileConsumer fileConsumer = new ConsumerJson();
        Conversor conversor = new ConvertToFaturamento(fileConsumer);
        try {
            return conversor.convert("src/main/java/dados/dadosJSON.json");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON.", e);
        }
    }
}
