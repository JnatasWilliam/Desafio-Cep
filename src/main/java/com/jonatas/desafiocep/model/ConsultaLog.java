package com.jonatas.desafiocep.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "logs_consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaLog {

    @Id
    private String id;
    private String usuarioId;
    private String cepConsultado;
    private LocalDateTime dataConsulta;
    private Map<String, Object> resultado;
    private String statusConsulta;
    private long tempoRespostaMs;
    private String origem;
}
