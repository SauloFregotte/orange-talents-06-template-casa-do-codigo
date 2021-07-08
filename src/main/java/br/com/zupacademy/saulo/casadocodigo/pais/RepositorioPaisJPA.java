package br.com.zupacademy.saulo.casadocodigo.pais;

import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioPaisJPA extends JpaRepository<Pais, Long> {

    Optional<Pais> findByNome(final String nome);
}
