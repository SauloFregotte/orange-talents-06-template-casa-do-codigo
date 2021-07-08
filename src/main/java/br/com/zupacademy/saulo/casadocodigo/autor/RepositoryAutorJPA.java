package br.com.zupacademy.saulo.casadocodigo.autor;

import br.com.zupacademy.saulo.casadocodigo.autor.entidade.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryAutorJPA extends JpaRepository<Autor, Long> {

    Optional<Autor> findFirstAutorByEmail(String email);

    Optional<Autor> findAutorByNome(String nome);
}
