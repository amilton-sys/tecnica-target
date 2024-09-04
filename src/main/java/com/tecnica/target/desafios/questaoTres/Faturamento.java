package com.tecnica.target.desafios.questaoTres;

import java.math.BigDecimal;
import java.util.Objects;

public class Faturamento {
    private int dia;
    private BigDecimal valor;

    public int getDia() {
        return dia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faturamento that = (Faturamento) o;
        return dia == that.dia;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dia);
    }

    @Override
    public String toString() {
        return "Faturamento{" +
                "dia=" + dia +
                ", valor=" + valor +
                '}';
    }
}
