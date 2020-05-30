package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.model.Automovel;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;

@UtilityClass
public class AutomovelTestHelper {

    public Automovel create() {
        return Automovel.builder()
                .nome("carro")
                .marca("Hyundai")
                .modelo("HB20")
                .dataFabricacao(LocalDate.now().minusYears(3))
                .consumoMedioCidade(new BigDecimal("12.0"))
                .consumoMedioRodovia(new BigDecimal("14.0"))
                .build();
    }

    public Automovel createComValores(String consumoMedioCidade, String consumoMedioRodovida) {
        return Automovel.builder()
                .nome("carro")
                .marca("Hyundai")
                .modelo("HB20")
                .dataFabricacao(LocalDate.now().minusYears(3))
                .consumoMedioCidade(new BigDecimal(consumoMedioCidade))
                .consumoMedioRodovia(new BigDecimal(consumoMedioRodovida))
                .build();
    }

}
