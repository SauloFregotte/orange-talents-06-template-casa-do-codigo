package br.com.zupacademy.saulo.casadocodigo.livro;

import br.com.zupacademy.saulo.casadocodigo.livro.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryLivroJPA extends JpaRepository<Livro, Long> {

    Optional<Livro> findFirstLivroByTitulo(String titulo);

    Optional<Livro> findFirstLivroByIsbn(String isbn);

}
