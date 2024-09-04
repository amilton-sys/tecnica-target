package com.tecnica.target.desafios.questaoCinco;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char[] texto = "amilton".toCharArray();
        String reversed = reverse(texto);
        System.out.println(reversed);
    }

    private static String reverse(char[] texto) {
        char[] textoCopia = Arrays.copyOf(texto, texto.length);
        int j = textoCopia.length - 1;
        for (int i = 0; i < j; i++, j--) {
            char aux = textoCopia[i];
            textoCopia[i] = textoCopia[j];
            textoCopia[j] = aux;
        }
        return new String(textoCopia);
    }
}
