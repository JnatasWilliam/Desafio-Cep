package com.jonatas.desafiocep.repository;

import com.jonatas.desafiocep.model.ConsultaLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaLogRepository extends MongoRepository<ConsultaLog, String> {
    Page<ConsultaLog> findAll(Pageable pageable);

    Page<ConsultaLog> findByStatusConsulta(String statusConsulta, Pageable pageable);

    Page<ConsultaLog> findByUsuarioId(String usuarioId, Pageable pageable);

}