package com.jonatas.desafiocep.controller;

import com.jonatas.desafiocep.model.ConsultaLog;
import com.jonatas.desafiocep.repository.ConsultaLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/logs")
public class LogController {

    private final ConsultaLogRepository repo;

    public LogController(ConsultaLogRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Page<ConsultaLog> listarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping(params = "status")
    public Page<ConsultaLog> filtrarPorStatus(
            @RequestParam String status,
            Pageable pageable
    ) {
        return repo.findByStatusConsulta(status, pageable);
    }

    @GetMapping(params = "usuarioId")
    public Page<ConsultaLog> filtrarPorUsuario(
            @RequestParam String usuarioId,
            Pageable pageable
    ) {
        return repo.findByUsuarioId(usuarioId, pageable);
    }
}