package br.victor.desafio.cep.modelos;

import br.victor.desafio.cep.excecao.InvalidCepException;

public class ValidadorCep {

    public static void validarCep (String cep) throws InvalidCepException {

        if (cep == null ||!cep.matches("\\d{8}") ){
            throw new InvalidCepException("CEP Inválido! Favor atentar-se ao padrão de 8 digitos numéricos");

        }

    }
}
