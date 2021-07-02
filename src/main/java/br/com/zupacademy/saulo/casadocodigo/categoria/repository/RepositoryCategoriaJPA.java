package br.com.zupacademy.saulo.casadocodigo.categoria.repository;

import br.com.zupacademy.saulo.casadocodigo.categoria.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryCategoriaJPA extends JpaRepository<Categoria,Long> {

    Optional<Categoria> findFirstCategoriaByNome(String nome);
}
