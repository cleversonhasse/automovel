package br.com.desafio.automovel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@ToString
@Table(name = "automovel")
public class Automovel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_automovel")
    private Long id;

    @Size(max = 100)
    @Column(name = "nome")
    private String nome;

    @Size(max = 100)
    @Column(name = "marca")
    private String marca;

    @Size(max = 100)
    @Column(name = "modelo")
    private String modelo;

    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 2, fraction = 2)
    @Column(name = "consumo_medio_cidade")
    private BigDecimal consumoMedioCidade;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 2, fraction = 2)
    @Column(name = "consumo_medio_rodovia")
    private BigDecimal consumoMedioRodovia;

}
