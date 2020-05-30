package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.exception.AutomovelException;

import java.time.LocalDate;

public class AutomovelValidator {

    public static void validateDataFabricacao(LocalDate dataFabricacao) throws AutomovelException {
        if (dataFabricacao.isAfter(LocalDate.now())) {
            throw new AutomovelException("Data Fabricação não pode ser maior que a data atual.");
        }
    }

}
