package br.com.inmetrics.teste.support;

import java.util.Random;

public class GeradorNumeroUsuario {


    public static String retornaNovoNumero() {
        Random r = new Random();
        return String.valueOf(r.nextInt());
    }
}
