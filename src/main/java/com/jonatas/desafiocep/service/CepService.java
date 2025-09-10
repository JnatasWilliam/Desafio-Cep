package com.jonatas.desafiocep.service;

import com.jonatas.desafiocep.model.ConsultaLog;
import com.jonatas.desafiocep.repository.ConsultaLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class CepService {

    private final ConsultaLogRepository logRepo;

    public CepService(ConsultaLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    public Map<String, Object> consultarCep(String cep) {
        var inicio = System.currentTimeMillis();
        // Por enquanto, mock do resultado:
        Map<String,Object> dados = Map.of(
                "logradouro", "Rua Falsa",
                "bairro", "Centro",
                "cidade", "São Falsário",
                "uf", "FS"
        );

        // Cria log
        var log = new ConsultaLog(
                null,
                "USUARIO_EXEMPLO",
                cep,
                LocalDateTime.now(),
                dados,
                "sucesso",
                System.currentTimeMillis() - inicio,
                "api-interna"
        );
        logRepo.save(log);

        return dados;
    }
}