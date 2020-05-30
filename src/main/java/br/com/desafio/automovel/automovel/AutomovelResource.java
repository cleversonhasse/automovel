package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.dto.ParametrosCalculoDTO;
import br.com.desafio.automovel.dto.RetornoCalculoDTO;
import br.com.desafio.automovel.model.Automovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/automovel")
public class AutomovelResource {

    private final AutomovelService automovelService;

    @Autowired
    public AutomovelResource(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<Automovel> findAll() {
        return automovelService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Automovel create(@Valid @RequestBody Automovel entity) {
        return automovelService.insert(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        automovelService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Automovel update(@Valid @RequestBody Automovel entity) {
        return automovelService.update(entity);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/calculo")
    public List<RetornoCalculoDTO> calculo(@Valid @RequestBody ParametrosCalculoDTO parametrosCalculo) {
        return automovelService.calculo(parametrosCalculo);
    }

}
