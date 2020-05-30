package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.dto.ParametrosCalculoDTO;
import br.com.desafio.automovel.dto.RetornoCalculoDTO;
import br.com.desafio.automovel.model.Automovel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutomovelService {

    private final AutomovelRepository automovelRepository;

    public List<Automovel> findAll() {
        return automovelRepository.findAll();
    }

    public Automovel insert(Automovel entity) {
        validate(entity);
        return automovelRepository.save(entity);
    }

    public Automovel update(Automovel entity) {
        validate(entity);
        return automovelRepository.save(entity);
    }

    public void delete(Long id) {
        automovelRepository.deleteById(id);
    }

    public List<RetornoCalculoDTO> calculo(ParametrosCalculoDTO parametrosCalculo) {
        List<RetornoCalculoDTO> list = new ArrayList<>();

        findAll().forEach(automovel -> {
            BigDecimal quantidadeCombustivelGastoCidade = parametrosCalculo.getDistanciaPercorridaCidade()
                    .divide(automovel.getConsumoMedioCidade(), 3, RoundingMode.HALF_UP);
            BigDecimal quantidadeCombustivelGastoRodovia = parametrosCalculo.getDistanciaPercorridaRodovia()
                    .divide(automovel.getConsumoMedioRodovia(), 3, RoundingMode.HALF_UP);
            BigDecimal quantidadeCombustivelGasto = quantidadeCombustivelGastoCidade.add(quantidadeCombustivelGastoRodovia);

            BigDecimal valorTotalGasto = quantidadeCombustivelGasto
                    .multiply(parametrosCalculo.getPreco()).setScale(2, RoundingMode.HALF_UP);

            list.add(RetornoCalculoDTO.builder()
                    .ano(automovel.getDataFabricacao().getYear())
                    .marca(automovel.getMarca())
                    .modelo(automovel.getModelo())
                    .nome(automovel.getNome())
                    .quantidadeCombustivelGasto(quantidadeCombustivelGasto)
                    .valorTotalGasto(valorTotalGasto)
                    .build());
        });

        return list;
    }

    public Optional<Automovel> findOne(Long id) {
        return automovelRepository.findById(id);
    }

    private void validate(Automovel automovel) {
        AutomovelValidator.validateDataFabricacao(automovel.getDataFabricacao());
    }

}
