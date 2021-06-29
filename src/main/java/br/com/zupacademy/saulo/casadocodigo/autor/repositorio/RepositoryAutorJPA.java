package br.com.zupacademy.saulo.casadocodigo.autor.repositorio;

import br.com.zupacademy.saulo.casadocodigo.autor.entidade.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAutorJPA extends JpaRepository<Autor, Long> {
}
