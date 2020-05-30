package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.TestUtil;
import br.com.desafio.automovel.model.Automovel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutomovelResourceTest {

    @Autowired
    private AutomovelService automovelService;

    @Autowired
    private AutomovelRepository automovelRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AutomovelResource(automovelService)).build();
    }

    @After
    public void tearDown() {
        automovelRepository.deleteAll();
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/rest/automovel").contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(create())))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindAll() throws Exception {
        Automovel automovel = automovelService.insert(create());

        mockMvc.perform(get("/rest/automovel").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*].id").value(automovel.getId().intValue()))
                .andExpect(jsonPath("$.[*].nome").value(automovel.getNome()))
                .andExpect(jsonPath("$.[*].marca").value(automovel.getMarca()))
                .andExpect(jsonPath("$.[*].consumoMedioCidade").value(automovel.getConsumoMedioCidade().doubleValue()))
                .andExpect(jsonPath("$.[*].consumoMedioRodovia").value(automovel.getConsumoMedioRodovia().doubleValue()))
                .andExpect(jsonPath("$.[*].modelo").value(automovel.getModelo()));
    }

    @Test
    public void testUpdate() throws Exception {
        Automovel automovel = automovelService.insert(create());
        String atualizacao = "Teste";

        automovel.setNome(atualizacao);
        automovel.setMarca(atualizacao);

        mockMvc.perform(put("/rest/automovel").contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(automovel)))
                .andExpect(status().isOk());

        Automovel automovelAtualizado = automovelService.findOne(automovel.getId()).get();
        assertEquals(automovelAtualizado.getNome(), atualizacao);
        assertEquals(automovelAtualizado.getMarca(), atualizacao);
    }

    @Test
    public void testDelete() throws Exception {
        Automovel automovel = automovelService.insert(create());

        mockMvc.perform(
                delete("/rest/automovel/{ids}", automovel.getId()).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());

        Assert.assertTrue(automovelService.findAll().isEmpty());
    }


    private Automovel create() {
        return AutomovelTestHelper.create();
    }

}
