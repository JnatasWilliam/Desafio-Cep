package com.jonatas.desafiocep.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioDTO {
    private String username;
    private String email;
    private String role;
}
