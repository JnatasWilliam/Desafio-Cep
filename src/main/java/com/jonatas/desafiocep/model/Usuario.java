package com.jonatas.desafiocep.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    private String id;

    private String username;

    private String password;

    private String role; // Ex: "ROLE_USER", "ROLE_ADMIN"
}