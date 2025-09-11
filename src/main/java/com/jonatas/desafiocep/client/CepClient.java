package com.jonatas.desafiocep.client;

import com.jonatas.desafiocep.model.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "${cep.api.url}")
public interface CepClient {

    @GetMapping("/{cep}/json")
    CepDto buscar(@PathVariable("cep") String cep);
}