package com.tecnica.target.desafios.questaoUm;

public class Test {
    public static void main(String[] args) {
        System.out.println(valorSoma());
    }

    static int valorSoma(){
        int indice = 13, soma = 0, k = 0;
        while (k < indice){
            k += 1;
            soma += k;
        }
        return soma;
    }
}
