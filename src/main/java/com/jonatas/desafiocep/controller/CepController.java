package com.jonatas.desafiocep.controller;

import com.jonatas.desafiocep.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<?> consultaCep(@PathVariable String cep) {
        var resultado = cepService.consultarCep(cep);
        return ResponseEntity.ok(resultado);
    }
}