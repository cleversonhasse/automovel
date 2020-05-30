package br.com.desafio.automovel.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Builder(toBuilder = true)
@Data
public class ParametrosCalculoDTO {

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 2, fraction = 3)
    private BigDecimal preco;

    @DecimalMin(value = "0.0")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal distanciaPercorridaCidade;

    @DecimalMin(value = "0.0")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal distanciaPercorridaRodovia;

    public static ParametrosCalculoDTO populate(String distanciaPercorridaCidade, String distanciaPercorridaRodovia, String preco) {
        return ParametrosCalculoDTO.builder()
                .distanciaPercorridaCidade(new BigDecimal(distanciaPercorridaCidade))
                .distanciaPercorridaRodovia(new BigDecimal(distanciaPercorridaRodovia))
                .preco(new BigDecimal(preco))
                .build();
    }

}
