package com.mrohana.viacep.service;

import java.util.Date;

import com.mrohana.viacep.data.Endereco;
import com.mrohana.viacep.data.ViaCepRequest;
import com.mrohana.viacep.data.ViaCepResponse;
import com.mrohana.viacep.repository.ViaCepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    
    @Autowired
    private ViaCepRepository viaCepRepository;

    public ViaCepResponse getClientViaCep(ViaCepRequest request) {
        ViaCepResponse response = new ViaCepResponse(); 
        response.setRequest(request);
        response.setData(new Date());
        
        final String uri = "https://viacep.com.br/ws/{cep}/json/";
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(uri, Endereco.class, request.getCep());
        response.setResult(endereco!=null && endereco.getCep()!=null ? 1 : 0);
        response.setEndereco(endereco);
        response.setRequest(request);
        response.setData(new Date());

        viaCepRepository.insert(response);

        return response;
    }
}