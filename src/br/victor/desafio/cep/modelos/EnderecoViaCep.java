package br.victor.desafio.cep.modelos;

public record EnderecoViaCep(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) {}
