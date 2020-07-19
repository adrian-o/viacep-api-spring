package com.mrohana.viacep.controller;

import com.mrohana.viacep.data.ViaCepRequest;
import com.mrohana.viacep.data.ViaCepResponse;
import com.mrohana.viacep.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep")
public class CepController {
    
    @Autowired
    private CepService cepService;

    @CrossOrigin
    @PostMapping("endereco")
    public ResponseEntity<ViaCepResponse> getCep(@RequestBody ViaCepRequest request) {
        ViaCepResponse response = new ViaCepResponse();
        response.setRequest(request);
        try {
            response = cepService.getClientViaCep(request);
            
            if (response!=null && response.getResult() == 0) {
                response.setMensagem("CEP não encontrado na API do ViaCep");
                cepService.saveResponse(response);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            response.setMensagem("Erro ao consultar a API do ViaCep");
            cepService.saveResponse(response);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}