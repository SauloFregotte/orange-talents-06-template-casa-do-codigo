package br.com.zupacademy.saulo.casadocodigo.cliente;

import br.com.zupacademy.saulo.casadocodigo.cliente.entidade.ClienteRequest;
import br.com.zupacademy.saulo.casadocodigo.cliente.entidade.ClienteResponse;
import br.com.zupacademy.saulo.casadocodigo.estado.RepositorioEstadoJPA;
import br.com.zupacademy.saulo.casadocodigo.pais.RepositorioPaisJPA;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClienteController {

    private final RepositoryClienteJPA repositoryClienteJPA;
    private final RepositorioPaisJPA repositorioPaisJPA;
    private final RepositorioEstadoJPA repositorioEstadoJPA;

    public ClienteController(final RepositoryClienteJPA repositoryClienteJPA, final RepositorioPaisJPA repositorioPaisJPA, RepositorioEstadoJPA repositorioEstadoJPA){
        this.repositoryClienteJPA = repositoryClienteJPA;
        this.repositorioPaisJPA = repositorioPaisJPA;
        this.repositorioEstadoJPA = repositorioEstadoJPA;
    }

    @PostMapping(path = "/cadastrar-cliente")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse cadastrarCliente(@RequestBody @Valid final ClienteRequest clienteRequest){
        return clienteRequest.cadastrar(repositoryClienteJPA, repositorioPaisJPA, repositorioEstadoJPA);
    }
}
