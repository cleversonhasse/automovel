package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.dto.ParametrosCalculoDTO;
import br.com.desafio.automovel.dto.RetornoCalculoDTO;
import br.com.desafio.automovel.exception.AutomovelException;
import br.com.desafio.automovel.model.Automovel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutomovelServiceTest {

    private AutomovelService automovelService;

    @Autowired
    private AutomovelRepository automovelRepository;

    @Before
    public void setup() {
        automovelService = new AutomovelService(automovelRepository);
    }

    @After
    public void tearDown() {
        automovelRepository.deleteAll();
    }

    @Test
    public void testCalculo() throws Exception {
        automovelService.insert(create("10.0", "15.0"));

        ParametrosCalculoDTO parametrosCalculoDTO =
                ParametrosCalculoDTO.populate("20.0", "60.0", "4.0");
        List<RetornoCalculoDTO> list = automovelService.calculo(parametrosCalculoDTO);
        list.forEach(retornoCalculoDTO -> {
            assertEquals(new BigDecimal("6.000"), retornoCalculoDTO.getQuantidadeCombustivelGasto());
            assertEquals(new BigDecimal("24.00"), retornoCalculoDTO.getValorTotalGasto());
        });
    }

    @Test
    public void testCalculo2() throws Exception {
        automovelService.insert(create("9.3", "12.1"));

        ParametrosCalculoDTO parametrosCalculoDTO =
                ParametrosCalculoDTO.populate("16.83", "48.21", "3.67");
        List<RetornoCalculoDTO> list = automovelService.calculo(parametrosCalculoDTO);
        list.forEach(retornoCalculoDTO -> {
            assertEquals(new BigDecimal("5.794"), retornoCalculoDTO.getQuantidadeCombustivelGasto());
            assertEquals(new BigDecimal("21.26"), retornoCalculoDTO.getValorTotalGasto());
        });
    }

    @Test(expected = AutomovelException.class)
    public void testValidaDataFabricacao() throws Exception {
        Automovel automovel = AutomovelTestHelper.create();
        automovel.setDataFabricacao(LocalDate.now().plusDays(2L));
        automovelService.insert(automovel);
    }

    private Automovel create(String consumoMedioCidade, String consumoMedioRodovida) {
        return AutomovelTestHelper.createComValores(consumoMedioCidade, consumoMedioRodovida);
    }

}
