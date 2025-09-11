package com.jonatas.desafiocep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
}