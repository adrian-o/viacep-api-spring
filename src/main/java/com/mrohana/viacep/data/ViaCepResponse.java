package com.mrohana.viacep.data;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ViaCep")
public class ViaCepResponse {
    private ViaCepRequest request;
    private Date data;
    private Endereco endereco;
    private Integer result;
    private String mensagem;

    public ViaCepRequest getRequest() {
        return request;
    }

    public void setRequest(ViaCepRequest request) {
        this.request = request;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}