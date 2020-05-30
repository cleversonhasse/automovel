package br.com.desafio.automovel.automovel;

import br.com.desafio.automovel.model.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
