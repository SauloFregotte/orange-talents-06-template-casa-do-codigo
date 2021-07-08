package br.com.zupacademy.saulo.casadocodigo.cliente;

import br.com.zupacademy.saulo.casadocodigo.cliente.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryClienteJPA extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findFirstByCpf(final String cpf);

    Optional<Cliente> findFirstByEmail(final String email);
}
