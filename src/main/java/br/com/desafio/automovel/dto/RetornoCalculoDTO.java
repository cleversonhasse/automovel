package br.com.desafio.automovel.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Data
public class RetornoCalculoDTO {

    private String nome;

    private String marca;

    private String modelo;

    private Integer ano;

    private BigDecimal quantidadeCombustivelGasto;

    private BigDecimal valorTotalGasto;

}
