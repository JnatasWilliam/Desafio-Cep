package com.jonatas.desafiocep.service;

import com.jonatas.desafiocep.client.CepClient;
import com.jonatas.desafiocep.model.CepDto;
import com.jonatas.desafiocep.model.ConsultaLog;
import com.jonatas.desafiocep.model.Resultado;
import com.jonatas.desafiocep.repository.ConsultaLogRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class CepService {

    private final CepClient cepClient;
    private final ConsultaLogRepository logRepo;

    public CepService(CepClient cepClient, ConsultaLogRepository logRepo) {
        this.cepClient = cepClient;
        this.logRepo = logRepo;
    }

    public Resultado consultarCep(String cep) {
        Instant inicio = Instant.now();
        CepDto dto = cepClient.buscar(cep);

        Resultado resultado = new Resultado(
                dto.getLogradouro(),
                dto.getBairro(),
                dto.getLocalidade(),
                dto.getUf()
        );

        long tempoMs = Duration.between(inicio, Instant.now()).toMillis();

        ConsultaLog log = ConsultaLog.builder()
                .usuarioId(extrairUsuarioId())
                .cepConsultado(cep)
                .dataConsulta(LocalDateTime.now())
                .resultado(resultado)
                .statusConsulta("sucesso")
                .tempoRespostaMs(tempoMs)
                .origem("api-mockada")
                .build();

        logRepo.save(log);
        return resultado;
    }

    private String extrairUsuarioId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getName() : "anonymous";
    }
}