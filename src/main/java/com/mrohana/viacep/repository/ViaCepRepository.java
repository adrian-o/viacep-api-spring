package com.mrohana.viacep.repository;

import com.mrohana.viacep.data.ViaCepResponse;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViaCepRepository extends MongoRepository<ViaCepResponse, String> {
    
}