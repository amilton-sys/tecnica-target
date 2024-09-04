package com.tecnica.target.desafios.questaoDois;

public class Test {
    public static void main(String[] args) {
        int numero = 23;
        boolean isFibonacci = verificaFibonacci(numero);
        if (isFibonacci) {
            System.out.println("Fibonacci");
        }else {
            System.out.println("Não fibonacci");
        }
    }

    static boolean verificaFibonacci(int n) {
        int numeroAtual = 0;
        int numeroAnterior = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                numeroAtual = 1;
                numeroAnterior = 0;
            } else {
                numeroAtual += numeroAnterior;
                numeroAnterior = numeroAtual - numeroAnterior;
                if (n == numeroAtual) return true;
            }
        }
        return false;
    }
}
