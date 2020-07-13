package com.mrohana.viacep.controller;

import com.mrohana.viacep.data.ViaCepRequest;
import com.mrohana.viacep.data.ViaCepResponse;
import com.mrohana.viacep.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viacep-cli/cep")
public class CepController {
    
    @Autowired
    private CepService cepService;

    @PostMapping("endereco")
    public ResponseEntity<ViaCepResponse> getCep(@RequestBody ViaCepRequest request) {
        ViaCepResponse response = cepService.getClientViaCep(request);
        return ResponseEntity.ok().body(response);
    }
}