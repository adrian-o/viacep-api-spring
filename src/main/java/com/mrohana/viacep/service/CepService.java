package com.mrohana.viacep.service;

import java.util.Date;

import com.mrohana.viacep.data.Endereco;
import com.mrohana.viacep.data.ViaCepRequest;
import com.mrohana.viacep.data.ViaCepResponse;
import com.mrohana.viacep.repository.ViaCepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    
    @Autowired
    private ViaCepRepository viaCepRepository;

    @Value("${viacep.client.url}")
    private String viaCepUrl;    

    public ViaCepResponse getClientViaCep(ViaCepRequest request) {
        ViaCepResponse response = new ViaCepResponse();
        response.setData(new Date());
        
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(viaCepUrl, Endereco.class, request.getCep());
        response.setResult(endereco!=null && endereco.getCep()!=null ? 1 : 0);
        response.setEndereco(endereco);
        response.setRequest(request);
        response.setData(new Date());

        saveResponse(response);

        return response;
    }

    public void saveResponse(ViaCepResponse response) {
        viaCepRepository.insert(response);
    }
}