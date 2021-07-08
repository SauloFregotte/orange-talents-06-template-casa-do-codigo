package br.com.zupacademy.saulo.casadocodigo.estado;

import br.com.zupacademy.saulo.casadocodigo.estado.entidade.Estado;
import br.com.zupacademy.saulo.casadocodigo.pais.entidade.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioEstadoJPA extends JpaRepository<Estado, Long> {

        Optional<Estado> findByNomeAndPais(final String nome, final Pais pais);

}
