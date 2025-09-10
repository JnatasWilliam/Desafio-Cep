package com.jonatas.desafiocep.repository;

import com.jonatas.desafiocep.model.ConsultaLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaLogRepository extends MongoRepository<ConsultaLog, String> {
}