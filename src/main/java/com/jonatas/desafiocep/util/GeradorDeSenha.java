package com.jonatas.desafiocep.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenha {

    public static void main(String[] args) {
        var encoder = new BCryptPasswordEncoder();
        String senhaOriginal = "123456";
        String senhaCriptografada = encoder.encode(senhaOriginal);

        System.out.println("Senha original: " + senhaOriginal);
        System.out.println("Senha criptografada: " + senhaCriptografada);
    }
}
